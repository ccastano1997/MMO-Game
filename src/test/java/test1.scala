import org.scalatest._

class test1 extends FunSuite{
  test("Testing Damage"){
    val char1: Character=new Character(10,5,10,5,100,0,100,0)
    char1.takeDamage(4)

    assert(char1.dead==false)

    val char2: Character=new Character(1,2,3,3,4,5,6,45)
    assert(char2.dead==false)


    val char3: Character=new Character(1,2,3,3,20,5,6,45)
    char3.takeDamage(40)
    assert(char3.dead==true)












  }











}
