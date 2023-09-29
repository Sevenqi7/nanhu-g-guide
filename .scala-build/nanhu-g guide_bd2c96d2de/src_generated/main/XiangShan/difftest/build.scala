
package XiangShan.difftest



final class build$_ {
def args = build_sc.args$
def scriptPath = """XiangShan/difftest/build.sc"""
/*<script>*/
import mill._, scalalib._
import coursier.maven.MavenRepository

trait CommonModule extends ScalaModule {
  override def scalaVersion = "2.12.13"

  override def scalacOptions = Seq("-Xsource:2.11")
}

trait HasXsource211 extends ScalaModule {
  override def scalacOptions = T {
    super.scalacOptions() ++ Seq(
      "-deprecation",
      "-unchecked",
      "-Xsource:2.11"
    )
  }
}

trait HasChisel3 extends ScalaModule {
   override def ivyDeps = Agg(
    ivy"edu.berkeley.cs::chisel3:3.5.0-RC1"
 )
}

trait HasChiselTests extends CrossSbtModule  {
  object test extends Tests {
    override def ivyDeps = Agg(ivy"org.scalatest::scalatest:3.0.4", ivy"edu.berkeley.cs::chisel-iotesters:1.2+")
    def testFrameworks = Seq("org.scalatest.tools.Framework")
  }
}

object difftest extends SbtModule with CommonModule with HasChisel3 {
  override def millSourcePath = os.pwd / "difftest"
}

object chiselModule extends CrossSbtModule with HasChisel3 with HasChiselTests with HasXsource211 {
  def crossScalaVersion = "2.12.13"
  override def moduleDeps = super.moduleDeps ++ Seq(
    difftest
  )
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

