import org.scalatest._

class test2 extends FunSuite {
  test("Testing Attack"){
    var enemy:Character=new Character(10,5,10,5,100,0,100,0)
    var User: Character=new Character(10,5,10,5,100,0,100,0)
    User.physical_attack(enemy)
    assert(User.MaxHP==95)

    User.magic_attack(enemy)
    assert(User.MaxHP==90)

    User.magic_attack(enemy)
    assert(User.MaxHP==85)


//User is being attacked by enemy
    var enemy1:Character=new Character(10,5,10,5,100,0,100,0)
    var User1: Character=new Character(10,5,10,5,50,0,100,0)
    User1.physical_attack(enemy1)
    assert(User1.MaxHP==45)



  }

}
