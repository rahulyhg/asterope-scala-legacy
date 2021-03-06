package org.asterope.geometry;

import org.asterope.util._
import org.apache.commons.math.geometry.Vector3D

class TransformerTest extends ScalaTestCase{

  def testPerformance(){

    val projecters = List[Projecter](ProjecterAit, ProjecterArc, ProjecterCar, 
        new ProjecterHpx(), ProjecterSfl, ProjecterSin, ProjecterStg, ProjecterTan, 
        ProjecterZea)
    val tp = new TablePrinter()

    projecters.foreach{p=>
      val from = Vector3D_m13.toArray
      val to = new Array[Double](2)
      tp.perfTest("proj",p.getName, 100, {
        p.transform(from, to)
      })
      tp.perfTest("projInv",p.getName,100, {
        p.inverse.transform(to, from)
      })

    }
    tp.print()
  }

}