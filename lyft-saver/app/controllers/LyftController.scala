package controllers

import services.LyftData
import akka.actor.ActorSystem
import javax.inject._
import play.api._
import play.api.libs.json._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.concurrent.duration._


@Singleton
class LyftController @Inject() (actorSystem: ActorSystem)(implicit exec: ExecutionContext) extends Controller {


  def cost = Action {
    val costs: JsObject = JsObject(List(("Cost", JsNumber(LyftData.getCost()))))
    Ok(costs)
    //    Ok(JsObject(List((JsString("Cost"), JsNumber(100)))))
  }


}
