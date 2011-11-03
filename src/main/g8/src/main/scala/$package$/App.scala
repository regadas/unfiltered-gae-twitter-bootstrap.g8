package $package$

import unfiltered.request._
import unfiltered.response._

/** unfiltered plan */
class App extends unfiltered.filter.Plan with Template {
  import QParams._

  def intent = {
    case GET(Path("/")) =>
      Ok ~> view(Map.empty)(<p> What say you? </p>)
    case POST(Path(p) & Params(params)) =>
      val vw = view(params)_
      val expected = for {
        int <- lookup("int") is
          int { _ + " is not an integer" } is
          required("missing int")
        word <- lookup("palindrome") is
          trimmed is
          nonempty("Palindrome is empty") is
          pred(palindrome, _ + " is not a palindrome") is
          required("missing palindrome")
      } yield vw(
        <div class="alert-message success">
          <p><strong>Yup. { int.get } is an integer and { word.get } is a palindrome.</strong></p>
        </div>)
      expected(params) orFail { fails =>
        vw(
          {
            fails.map { f =>
              <div class="alert-message error">
                <p><strong>{ f.error }</strong></p>
              </div>
            }
          })
      }
  }

  def palindrome(s: String) = s.toLowerCase.reverse == s.toLowerCase

  def view(params: Map[String, Seq[String]])(body: scala.xml.NodeSeq) = {
    def p(k: String) = params.get(k).flatMap { _.headOption } getOrElse ("")
    layout(Nil)(Nil)(
      <div>
        { body }
      </div>
      <form method="POST" class="form-stacked">
        <div class="clearfix">
          <label for="integer">Integer</label>
          <div class="input">
            <input class="xlarge" id="integer" name="int" size="30" type="text" value={ p("int") }/>
          </div>
        </div>
        <div class="clearfix">
          <label for="integer">Palindrome</label>
          <div class="input">
            <input class="xlarge" id="integer" name="palindrome" size="30" type="text" value={ p("palindrome") }/>
          </div>
        </div>
        <input type="submit" class="btn primary"/>
      </form>)
  }
}
