import org.scalatest._
class test3 extends FunSuite {
  test("Testing experience"){
    val char4: Character=new Character(10,5,10,5,100,0,100,0)
    char4.level_up(char4,7)
    char4.level_up(char4,4)




    assert(char4.level==3) //testing if level is incremented
    assert(char4.xp==11) //testing if xp variable exist and is increasing
    assert(char4.attackPower==40) //testing if stats are increased if level and xp are increased
    assert(char4.Defense==20)
    assert(char4.MagicAttack==40)
    assert(char4.Magic_defense==20)
    assert(char4.MaxHP==400)
    assert(char4.CHP==0)
    assert(char4.MaxHP==400)
    assert(char4.CMP==0)

//increasing the player to level 5
    char4.level_up(char4,10)
    assert(char4.level==5) //testing if level is incremented
    assert(char4.xp==21) //testing if xp variable exist and is increasing
    assert(char4.attackPower==60)
    assert(char4.Defense==30)
    assert(char4.MagicAttack==60)
    assert(char4.Magic_defense==30)
    assert(char4.MaxHP==600)
    assert(char4.CHP==0)
    assert(char4.MaxHP==600)
    assert(char4.CMP==0)













    //Testing if experience is transferable**************Requirement #4 ,killing a lower level
    val char5: Character=new Character(0,0,0,0,0,0,0,0)
    char5.level_up(char5,7)
    char5.level_up(char5,4)   //a level 3 //11xp
    val char6: Character=new Character(0,0,0,0,0,0,0,0)
    char6.level_up(char6,7)//a level 2
    char6.dead=true
    char6.takeXP(char6,char5)
    assert(char5.xp==18) //char5 gains 7 xp for killing a level 2

//Killing a higher level
    val char69: Character=new Character(0,0,0,0,0,0,0,0)
    char69.level_up(char69,7)
    char69.level_up(char69,3)   //a level 3 //10xp
    val char23: Character=new Character(0,0,0,0,0,0,0,0)
    char23.level_up(char23,7)//a level 2
    char69.dead=true
    char23.takeXP(char23,char69)
    assert(char23.xp==17) //char23 gains 10 xp for killing a level 3, a level higher



















  }

}
