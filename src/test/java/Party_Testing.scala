import org.scalatest._

class Party_Testing extends FunSuite {
  test("Testing Party"){
    //Finding a parties total xp
    val char1: Character=new Character(10,5,10,5,100,0,100,0)
    char1.level_up(char1,7)
    val char2: Character=new Character(10,5,10,5,100,0,100,0)
    char2.level_up(char2,8)


    val party1:Party=new Party( List(char1,char2))
    party1.findPartyXP()
    assert(party1.allX_P==15)

//****************testing party xp gain
    //Party 2 defeated party4
    //party 2, only 1 party member is dead

    val char12: Character=new Character(10,5,10,5,100,0,100,0)
    char12.level_up(char12,5)
    val char21: Character=new Character(10,5,10,5,100,0,100,0)
    char21.level_up(char21,5)
    char21.dead=true


    val party2:Party=new Party( List(char12,char21))
    //*****************
    //party 4 are all dead
    val char34: Character=new Character(10,5,10,5,100,0,100,0)
    char34.level_up(char34,7)
    char34.dead=true
    val char35: Character=new Character(10,5,10,5,100,0,100,0)
    char35.level_up(char35,8)
    char35.dead=true
    val party4:Party=new Party( List(char34,char35))

    party2.gainPartyXP(party2,party4)



//testing to see what party was defeated
    assert(party4.partyLifeDead==true)
    assert(party2.partyLifeDead==false)
//test if xp is added to characters who are alive
    assert(char12.xp==20)
    assert(char21.xp==5)
    assert(char34.xp==7)
    assert(char35.xp==8)



    //*************************************************************
    //Testing second scenario party 6 wins, and everyone in party5 dies
    val char99: Character=new Character(10,5,10,5,100,0,100,0)
    char99.level_up(char99,5)
    char99.dead=true

    val char100: Character=new Character(10,5,10,5,100,0,100,0)
    char100.level_up(char100,6)
    char100.dead=true


    val party5:Party=new Party( List(char99,char100))
    //*****************
    //party 6 everyone is alive
    val char101: Character=new Character(10,5,10,5,100,0,100,0)
    char101.level_up(char101,7)

    val char102: Character=new Character(10,5,10,5,100,0,100,0)
    char102.level_up(char102,8)
    val party6:Party=new Party( List(char101,char102))

    party5.gainPartyXP(party5,party6)

    //testing to see what party was defeated
    assert(party5.partyLifeDead==true)
    assert(party6.partyLifeDead==false)
    //test if xp is added to characters who are alive
    assert(char99.xp==5)
    assert(char100.xp==6)
    assert(char101.xp==12)
    assert(char102.xp==13)




  }



}
