import pt.isel.canvas.*

const val CANVAS_WIDTH = 700
const val CANVAS_HEIGHT = 600

const val SPRITE_WIDTH = 56
const val SPRITE_HEIGHT = 56
const val SPRITESHEET_COLUMNS = 4
const val SPRITESHEET_ROWS = 4

// Image dimensions and origin
//const val IMAGE_WIDTH = 75
//const val IMAGE_HEIGHT = 75
//const val ORIG_X = 10
//const val ORIG_Y = 10
//const val IMAGE_WIDTH = 100
//const val IMAGE_HEIGHT = 100
const val IMAGE_WIDTH = 200
const val IMAGE_HEIGHT = 200
const val ORIG_X = 100
const val ORIG_Y = 100

const val FRAME_PERIOD = 1000

fun drawActor(canvas: Canvas, spriteCoords: String) {
    canvas.drawRect(ORIG_X, ORIG_Y, IMAGE_WIDTH, IMAGE_HEIGHT, thickness = 1)
    canvas.drawImage("arshes13.png|$spriteCoords", ORIG_X, ORIG_Y, IMAGE_WIDTH, IMAGE_HEIGHT)
}


fun main() {

    onStart {
        val canvas = Canvas(CANVAS_WIDTH, CANVAS_HEIGHT, WHITE)

        var animationStep = 0
        var direction = 0
        var spriteRectX = 0
        var spriteRectY = 0

        var spriteCoords = "$spriteRectX,$spriteRectY,$SPRITE_WIDTH,$SPRITE_HEIGHT"
        println(spriteCoords)
        // Draw actor
        drawActor(canvas, spriteCoords)

        canvas.onTimeProgress(FRAME_PERIOD) {
            animationStep = (animationStep + 1) % SPRITESHEET_COLUMNS
            // Each time the animationStep == 0, increment direction
            if (animationStep == 0) {
                direction = (direction + 1) % SPRITESHEET_ROWS
            }
            // Recalculate sprite coordinates
            spriteRectX = animationStep * SPRITE_WIDTH
            spriteRectY = direction * SPRITE_HEIGHT

            spriteCoords = "$spriteRectX,$spriteRectY,$SPRITE_WIDTH,$SPRITE_HEIGHT"
            println(spriteCoords)

            canvas.erase()
            // Redraw actor
            drawActor(canvas, spriteCoords)
        }
    }

    onFinish {
        println("Bye")
    }

}



























