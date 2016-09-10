package controllers

import services.Functions
import services.TripObject
import akka.actor.ActorSystem
import javax.inject._
import play.api._
import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.concurrent.duration._


@Singleton
class LyftController @Inject() (actorSystem: ActorSystem)(implicit exec: ExecutionContext) extends Controller {


  def cost (startLat: Double, startLong: Double, endLat: Double, endLong: Double) = Action {
    val best: TripObject = Functions.getCheapest(startLat, startLong, endLat, endLong)
    val json: JsObject = JsObject(List(("Cost", JsNumber(best.getCost())),
      ("Starting Latitude", JsNumber(best.getStartLat())),
      ("Starting Longitude", JsNumber(best.getStartLong()))))
    Ok(json)
  }


}
