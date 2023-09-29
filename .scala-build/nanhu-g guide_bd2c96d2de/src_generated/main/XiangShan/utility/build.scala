
package XiangShan.utility



final class build$_ {
def args = build_sc.args$
def scriptPath = """XiangShan/utility/build.sc"""
/*<script>*/
import mill._
import scalalib._
import scalafmt._

val defaultVersions = Map(
  "chisel3" -> "3.5.0",
  "chisel3-plugin" -> "3.5.0",
  "chiseltest" -> "0.3.2",
  "scala" -> "2.12.13",
  "scalatest" -> "3.2.7"
)

def getVersion(dep: String, org: String = "edu.berkeley.cs", cross: Boolean = false) = {
  val version = sys.env.getOrElse(dep + "Version", defaultVersions(dep))
  if (cross)
    ivy"$org:::$dep:$version"
  else
    ivy"$org::$dep:$version"
}

trait CommonModule extends ScalaModule {
  override def scalaVersion = defaultVersions("scala")

  override def scalacOptions = Seq("-Xsource:2.11")

  val macroParadise = ivy"org.scalamacros:::paradise:2.1.1"

  override def compileIvyDeps = Agg(macroParadise)
  override def scalacPluginIvyDeps = Agg(macroParadise)

}


object `rocket-chip` extends SbtModule with CommonModule {

  override def ivyDeps = super.ivyDeps() ++ Agg(
    ivy"${scalaOrganization()}:scala-reflect:${scalaVersion()}",
    ivy"org.json4s::json4s-jackson:3.6.1",
    getVersion("chisel3"),
  )

  object macros extends SbtModule with CommonModule

  object `api-config-chipsalliance` extends CommonModule {
    override def millSourcePath = super.millSourcePath / "design" / "craft"
  }

  object hardfloat extends SbtModule with CommonModule {
    override def ivyDeps = super.ivyDeps() ++ Agg(getVersion("chisel3"))
  }

  override def moduleDeps = super.moduleDeps ++ Seq(
    `api-config-chipsalliance`, macros, hardfloat
  )

}

object utility extends SbtModule with ScalafmtModule with CommonModule {

  override def millSourcePath = millOuterCtx.millSourcePath


  override def ivyDeps = super.ivyDeps() ++ Agg(
    getVersion("chisel3"),
    getVersion("chiseltest"),
  )

  override def moduleDeps = super.moduleDeps ++ Seq(`rocket-chip`)

  object test extends Tests {
    override def ivyDeps = super.ivyDeps() ++ Agg(
      getVersion("scalatest","org.scalatest")
    )

    def testFrameworks = Seq("org.scalatest.tools.Framework")
  }
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

