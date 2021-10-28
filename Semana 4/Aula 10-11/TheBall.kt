import pt.isel.canvas.*

const val WIDTH = 400
const val HEIGHT = 200
const val BACK_COLOR = CYAN
//const val BACK_COLOR = RED


fun main() {
    print("Begin ")
    onStart {
//        val arena = Canvas(300, 200, CYAN)
        val arena = Canvas(WIDTH, HEIGHT, BACK_COLOR)

        print("Start ")

        arena.drawCircle(WIDTH / 2, HEIGHT / 2, 30, RED)

        arena.onKeyPressed { keyEvent: KeyEvent ->
            when (keyEvent.code) {
                LEFT_CODE -> {
                    arena.erase()
                    arena.drawCircle(WIDTH / 2 - 20, HEIGHT / 2, 30, RED)
                }
            }
        }

    }
    onFinish {
        print("Finish ")
    }
    print("End ")
}