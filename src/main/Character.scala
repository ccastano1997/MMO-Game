class Character(var attackPower:Int,var Defense:Int,var MagicAttack:Int,var Magic_defense:Int,var MaxHP:Int,var CHP:Int,var MaxMP:Int,var CMP:Int) {
  var dead: Boolean = false
  var xp: Int = 0
  var level: Int = 0
  var levelUP: Int = 1
  var multi: Int = 2
  //Character(10,5,10,5,100,0,100,0)
  var defaultaP: Int = 10
  var defaultD: Int = 5
  var defaultmA: Int = 10
  var defaultmD: Int = 5
  var defaultMHP: Int = 100
  var defaultCHP: Int = 0
  var defaultMMP: Int = 100
  var defaultCMP: Int = 0


  def takeDamage(c: Int): Unit = {
    this.MaxHP -= c
    if (MaxHP <= 0) {
      dead = true
    }


  }

  def physical_attack(c1: Character): Unit = {
    var carlos: Int = c1.attackPower - Defense
    takeDamage(carlos)


  }

  def magic_attack(c2: Character): Unit = {
    var it2: Int = c2.MagicAttack - Magic_defense
    c2.MaxMP -= 5
    if (c2.MaxMP == 0) {
      it2 = 0

    }
    else {
      takeDamage(it2)

    }


  }

  //******************************Project "Experience" Part

  def level_up(c3: Character, gained: Int): Unit = {
    var count: Int = 1
    c3.xp += gained


    if (c3.xp >= levelUP) {
      var curr_xp: Int = c3.xp


      while (c3.xp >= c3.levelUP) {
        curr_xp -= 1
        count += 1
        c3.level += 1
        c3.levelUP += c3.multi
        c3.multi += 2

      }



      //***************************************Stats increase by level****************************************************************




    }
    if (c3.level != 0) {
      //Character(10,5,10,5,100,0,100,0)
      c3.attackPower = defaultaP * (level + 1)
      c3.Defense = defaultD * (level + 1)
      c3.MagicAttack = defaultmA * (level + 1)
      c3.Magic_defense = defaultmD * (level + 1)
      c3.MaxHP = defaultMHP * (level + 1)
      c3.CHP = defaultCHP * (level + 1)
      c3.MaxMP = defaultMMP * (level + 1)
      c3.CMP = defaultCMP * (level + 1)


    }
    if (c3.level == 0) {
      //Character(10,5,10,5,100,0,100,0)
      c3.attackPower = defaultaP
      c3.Defense = defaultD
      c3.MagicAttack = defaultmA
      c3.Magic_defense = defaultmD
      c3.MaxHP = defaultMHP
      c3.CHP = defaultCHP
      c3.MaxMP = defaultMMP
      c3.CMP = defaultCMP


    }

  }//***************end of level_Up

  def takeXP(c5:Character,c6:Character): Unit ={
    if (c5.dead==true){
        c6.xp+=c5.xp
    }
    if (c6.dead==true){
      c5.xp+=c6.xp
    }

  }
}
