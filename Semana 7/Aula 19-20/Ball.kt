import pt.isel.canvas.*

const val ARENA_WIDTH = 600
const val ARENA_HEIGHT = 300

const val LEFT = 0
const val RIGHT = 1
const val UP = 2
const val DOWN = 3

// Delta of 4 pixels
const val DELTA = 4
//const val DELTA = 1
//const val DELTA = 10

// Time progress period
//val PERIOD = 100
//val PERIOD = 5
val PERIOD = 15


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
// Version 3: Ball has an Offset vector
data class Ball(val position: Position, val radius: Int, val color: Int = RED, val offsetVector: OffsetVector)


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


// Version 4: Ball has an Offset vector; Diagonals + Reflection
fun Ball.move(arena: Canvas): Ball {
    val newPosition = this.position + offsetVector // Calls defined operator + above
    // Current position
    val (x, y) = this.position
    return when {
        x !in radius..arena.width - radius ->
            Ball(Position(x - offsetVector.dx, y), radius, color,
                OffsetVector(-offsetVector.dx, offsetVector.dy))
        y !in radius..arena.height - radius ->
            Ball(Position(x, y - offsetVector.dy), radius, color,
                OffsetVector(offsetVector.dx, -offsetVector.dy))
        else ->
            //Ball(newPosition, radius, color, offsetVector)
        // Or, using copy:
        this.copy(position = newPosition)
    }
}

private operator fun OffsetVector.unaryMinus(): OffsetVector = OffsetVector(-dx, -dy)


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
        // Version 4 - Diagonals + reflection
        val offsetVector = OffsetVector(-DELTA, (-DELTA..DELTA).random())
        var ball = Ball(center, 40, RED, offsetVector)
        // Draw ball
        arena.draw(ball)

        // Process keys
        arena.onKeyPressed { keyEvent ->
            // Version 3 and Version 4
            ball = when (keyEvent.code) {
                LEFT_CODE  ->  Ball(ball.position, ball.radius, ball.color, OffsetVector(-DELTA, 0))
                RIGHT_CODE ->  Ball(ball.position, ball.radius, ball.color, OffsetVector(DELTA, 0))
                UP_CODE    ->  Ball(ball.position, ball.radius, ball.color, OffsetVector(0, -DELTA))
                DOWN_CODE  ->  Ball(ball.position, ball.radius, ball.color, OffsetVector(0, DELTA))
                else       ->  ball
            }
        }

        // TimeProgress event
        arena.onTimeProgress(PERIOD) {
            ball = ball.move(arena)
            arena.draw(ball)
        }
    })
    onFinish {
        println("Bye")
    }
}





























