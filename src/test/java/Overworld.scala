import akka.actor.{Actor, ActorRef}
import javafx.event.EventHandler
import javafx.scene.input.KeyEvent
import scalafx.scene.shape.Shape


class OverworldSystem(server: ActorRef) extends Actor {



  override def receive: Receive = {

    case _ =>

  }



}


abstract class KeyboardInputs(player:Shape) extends EventHandler[KeyEvent] {

  val LEFT: String
  val RIGHT: String
  val JUMP: String
  val DOWN:String

  override def handle(event: KeyEvent): Unit = {
    val keyCode = event.getCode
    event.getEventType.getName match {
      case "KEY_RELEASED" => keyCode.getName match {
        case this.LEFT =>
        case this.RIGHT =>
        case this.JUMP =>
        case _ =>
      }
      case "KEY_PRESSED" => keyCode.getName match {
        case this.LEFT => player.translateX.value-=1.711111111111111111
        case this.RIGHT =>player.translateX.value+=1.7111111111111111111
        case this.JUMP => player.translateY.value-=1.111111111111111111
        case this.DOWN=>player.translateY.value+=1.555555555555555555
        case _ =>
      }
      case _ =>
    }
  }
  def increaseX():Unit={
    var x1:Double=player.translateX.value
    println(player.translateX.value)
    x1+=1
    player.translateX=x1
  }
}


class ArrowInputs(player:Shape ) extends KeyboardInputs(player) {
  override val LEFT: String = "Left"
  override val RIGHT: String = "Right"
  override val JUMP: String = "Up"
  override val DOWN: String = "Down"

}
