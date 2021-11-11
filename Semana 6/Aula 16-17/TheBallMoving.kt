import pt.isel.canvas.*

const val ARENA_WIDTH = 600
const val ARENA_HEIGHT = 300

const val LEFT = 0
const val RIGHT = 1
const val UP = 2
const val DOWN = 3

// Delta of 4 pixels
//const val DELTA = 4
const val DELTA = 1
//const val DELTA = 10

// Time progress period
//val period = 100
val period = 5


//
// Data class representing a Position
//
data class Position(val x: Int, val y: Int)
// operator + overload: sums an offset to a Position (referred to by this keyword) and returns the resulting Position
operator fun Position.plus(offset: OffsetVector) = Position(this.x + offset.dx, this.y + offset.dy)
// operator - overload
operator fun Position.minus(offset: OffsetVector) = Position(this.x - offset.dx, this.y - offset.dy)

//
// Data class representing an Offset vector
//
data class OffsetVector(val dx: Int, val dy: Int)

//
// Data class representing a Ball
//
// Version 1: Ball has a direction (LEFT, RIGHT, UP, DOWN)
data class Ball(val position: Position, val radius: Int, val color: Int = RED, val direction: Int)
// Version 3: Ball has a direction (LEFT, RIGHT, UP, DOWN)
//data class Ball(val position: Position, val radius: Int, val color: Int = RED, val offsetVector: OffsetVector)


//
// Extension Functions
//
// Draw ball in arena
fun Canvas.draw(ball: Ball) {
    // Erase arena
    this.erase()
    // Draw ball
    this.drawCircle(ball.position.x, ball.position.y, ball.radius, ball.color)
}

// Version 1: Ball has a direction (LEFT, RIGHT, UP, DOWN)
//fun Ball.move(arena: Canvas): Ball {
//    // Only LEFT and RIGHT directions are supported
//
//    if (this.direction == LEFT) {
//        val newX: Int
//        val direction: Int
//
//        if (this.position.x - this.radius - DELTA >= 0) {
//            newX = this.position.x - DELTA // Decrements x coordinate
//            direction = this.direction // Keeps the same direction
//        }
//        else {
//            newX = this.position.x + DELTA // Increments x coordinate
//            direction = RIGHT // Toggle direction
//        }
//        return Ball(Position(newX, this.position.y), this.radius, this.color, direction)
//    }
//    else {
//        val newX: Int
//        val direction: Int
//
//        if (this.position.x + this.radius + DELTA <= arena.width) {
//            newX = this.position.x + DELTA // Increments x coordinate
//            direction = this.direction // Keeps the same direction
//        }
//        else {
//            newX = this.position.x - DELTA // Decrements x coordinate
//            direction = LEFT // Toggle direction
//        }
//        return Ball(Position(newX, this.position.y), this.radius, this.color, direction)
//    }
//}

// Version 2: Ball has a direction (LEFT, RIGHT, UP, DOWN)
// Offset vector + directions
fun Ball.move(arena: Canvas): Ball {
    val offsetVector = when (this.direction) {
        LEFT -> OffsetVector(-DELTA, 0)
        RIGHT -> OffsetVector(DELTA, 0)
        UP -> OffsetVector(0, -DELTA)
        else -> /* DOWN */ OffsetVector(0, DELTA)
    }
    val newPosition = this.position + offsetVector // Calls defined operator + above
    // Current position
    val (x, y) = this.position  // Get x, y values from Position object
    return when {
        x !in radius .. arena.width - radius ->
            Ball(position - offsetVector, radius, color,
                if (direction == LEFT) RIGHT else LEFT )
        y !in radius .. arena.height - radius ->
            Ball(position - offsetVector, radius, color,
                if (direction == UP) DOWN else UP )
        else ->
            Ball(newPosition, radius, color, direction)
    }
}


// Version 3: Ball has an Offset vector
//fun Ball.move(arena: Canvas): Ball {
//    val newPosition = this.position + this.offsetVector // Calls defined operator + above
//    // Current position
//    val (x, y) = this.position
//    return when {
//        x !in radius..arena.width - radius ->
//            Ball(position - offsetVector, radius, color,
//                -offsetVector)
//        y !in radius..arena.height - radius ->
//            Ball(position - offsetVector, radius, color,
//                -offsetVector) // Unary minus works in this case, because we are using cardinal vectors
//                               // [(-1, 0), (1, 0), (0, -1), (0, 1)] = LEFT, RIGHT, UP, DOWN
//        else ->
//            Ball(newPosition, radius, color, offsetVector)
//    }
//}
//
// Version 4: Ball has an Offset vector; Diagonals + Reflection
//fun Ball.move(arena: Canvas): Ball {
//    val newPosition = this.position + offsetVector // Calls defined operator + above
//    // Current position
//    val (x, y) = this.position
//    return when {
//        x !in radius..arena.width - radius ->
//            Ball(Position(x - offsetVector.dx, y), radius, color,
//                OffsetVector(-offsetVector.dx, offsetVector.dy))
//        y !in radius..arena.height - radius ->
//            Ball(Position(x, y - offsetVector.dy), radius, color,
//                OffsetVector(offsetVector.dx, -offsetVector.dy))
//        else ->
//            Ball(newPosition, radius, color, offsetVector)
//    }
//}

private operator fun OffsetVector.unaryMinus(): OffsetVector = OffsetVector(-dx, -dy)

// Version 1 and 2
fun Ball.setDirection(direction: Int): Ball = Ball(this.position, this.radius, this.color, direction)


//fun main(): Unit {   // () -> Unit
// We can omit the Unit return type
fun main() {   // () -> Unit

    onStart( fx = {
        val arena = Canvas(width = ARENA_WIDTH, height = ARENA_HEIGHT, background = CYAN)
        //
        // Create ball instance
        //
        // Ball center
        val center = Position(ARENA_WIDTH / 2,ARENA_HEIGHT / 2)

        // Mutability point
        // Version 1 and 2
        var ball = Ball(center, 60, direction = LEFT)
        // Version 3
        // Initial offset vector
//        val offsetVector = OffsetVector(-DELTA, 0)  // LEFT vector
        // Version 4 - Diagonals + reflection
//        val offsetVector = OffsetVector(-DELTA, (-DELTA..DELTA).random())
//        var ball = Ball(center, 40, RED, offsetVector)
        // Draw ball
        arena.draw(ball)

        // Process keys
        arena.onKeyPressed { keyEvent ->
            // Version 2
            ball = when (keyEvent.code) {
                LEFT_CODE  ->  ball.setDirection(LEFT)
                RIGHT_CODE ->  ball.setDirection(RIGHT)
                UP_CODE    ->  ball.setDirection(UP)
                DOWN_CODE  ->  ball.setDirection(DOWN)
                else       ->  ball
            }
            // Version 3
//            ball = when (keyEvent.code) {
//                LEFT_CODE  ->  Ball(ball.position, ball.radius, ball.color, OffsetVector(-DELTA, 0))
//                RIGHT_CODE ->  Ball(ball.position, ball.radius, ball.color, OffsetVector(DELTA, 0))
//                UP_CODE    ->  Ball(ball.position, ball.radius, ball.color, OffsetVector(0, -DELTA))
//                DOWN_CODE  ->  Ball(ball.position, ball.radius, ball.color, OffsetVector(0, DELTA))
//                else       ->  ball
//            }
        }

        // TimeProgress event
        arena.onTimeProgress(period) {
            ball = ball.move(arena)
            arena.draw(ball)
        }
    })
    onFinish {
        println("Bye")
    }
}





























