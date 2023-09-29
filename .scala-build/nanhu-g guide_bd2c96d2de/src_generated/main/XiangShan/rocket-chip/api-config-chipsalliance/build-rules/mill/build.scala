
package XiangShan.rocket$minuschip.api$minusconfig$minuschipsalliance.build$minusrules.mill



final class build$_ {
def args = build_sc.args$
def scriptPath = """XiangShan/rocket-chip/api-config-chipsalliance/build-rules/mill/build.sc"""
/*<script>*/
import mill._
import mill.scalalib._
import mill.scalalib.publish._

object config extends config

class config extends ScalaModule {
  def scalaVersion = "2.12.12"
  def millSourcePath = os.pwd / os.up / os.up / 'design / 'craft
}

/*</script>*/ /*<generated>*/
/*</generated>*/
}

object build_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new build$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export build_sc.script as build

