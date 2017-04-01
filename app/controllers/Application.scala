package controllers

import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Hello, Mr. daniel!"))
  }

  def game = Action {
    Ok(views.html.game("play game"))
  }
}