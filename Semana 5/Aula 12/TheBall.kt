import pt.isel.canvas.*

const val WIDTH = 400
const val HEIGHT = 200
const val BACK_COLOR = CYAN
//const val BACK_COLOR = RED
const val DELTA = 10


// data class Ball
data class Ball(val xCenter: Int, val yCenter: Int, val radius: Int, val color: Int)

private fun Canvas.drawBall(ball: Ball) {
//    arena.erase()
    this.erase()
//    arena.drawCircle(WIDTH / 2 - 20, HEIGHT / 2, 30, RED)
    this.drawCircle(ball.xCenter, ball.yCenter, ball.radius, ball.color)
}

fun main() {
    print("Begin ")
    onStart {
//        val arena = Canvas(300, 200, CYAN)
        val arena = Canvas(WIDTH, HEIGHT, BACK_COLOR)
        print("Start ")
//        val ball: Ball = Ball(WIDTH / 2, HEIGHT / 2, 30, RED)
        // Use var here
        var ball: Ball = Ball(WIDTH / 2, HEIGHT / 2, 30, RED)

        arena.drawBall(ball)

//        arena.drawCircle(WIDTH / 2, HEIGHT / 2, 30, RED)

        arena.onKeyPressed { keyEvent: KeyEvent ->
            when (keyEvent.code) {
                LEFT_CODE -> {
                    ball = buildBallFromMoveLeft(ball)
                    arena.drawBall(ball)
//                    arena.erase()
//                    arena.drawCircle(WIDTH / 2 - 20, HEIGHT / 2, 30, RED)
                }
            }
        }

    }
    onFinish {
        print("Finish ")
    }
    print("End ")
}

fun buildBallFromMoveLeft(ball: Ball): Ball {
    return Ball(ball.xCenter - DELTA, ball.yCenter, ball.radius, ball.color)
}



