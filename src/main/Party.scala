class Party(var p1:List[Character]) {
  var allX_P: Int = 0
  var count: Int = 0
  var partyLifeDead: Boolean = false

  def findPartyXP(): Unit = {
    for (i <- p1) {
      allX_P += i.xp
      count += 1


    }

  }

  //***************************************************************************************************
  def gainPartyXP(pp1: Party, pp2: Party): Unit = {
    pp1.findPartyXP()
    pp2.findPartyXP()
    var pp1_count: Int = pp1.count
    var pp1_XP: Int = pp1.allX_P
    var pp1_deathCounter: Int = 0


    var pp2_count: Int = pp2.count
    var pp2_XP: Int = pp2.allX_P
    var pp2_deathCounter: Int = 0
    for (i1 <- pp1.p1) {
      if (i1.dead == true) {
        pp1_deathCounter += 1


      }//***************Checking if first party is dead
      if (pp1_deathCounter == pp1.count) {
        pp1.partyLifeDead = true

      }
      //ADD op xp to remaining character in parameter 1, split evenly amongst the characters
      if (pp1.partyLifeDead == true) {
        var holder1: Double = 0.00
        if((pp2_count-pp2_deathCounter)==0){
          holder1 = pp1.allX_P / pp2_count
          var new_xp: Int = holder1.toInt
          for (i1 <- pp1.p1) {
            if (i1.dead == true) {
              i1.xp += new_xp
            }
          }
        }
        if((pp2_count-pp2_deathCounter)!=0){
          holder1 = pp1.allX_P / (pp2_count-pp2_deathCounter)
          var new_xp: Int = holder1.toInt
          for (i1 <- pp2.p1) {
            if (i1.dead == false) {
              i1.xp += new_xp
            }
          }

        }

      }
      //End of xp addition
    }
    // ***************************checking 2nd party in parameter***********************************************************************************
    for (i1 <- pp2.p1) {
      if (i1.dead == true) {
        pp2_deathCounter += 1


      }
      if (pp2_deathCounter == pp2.count) {
        pp2.partyLifeDead = true
      }


    }


    //***************************************************************
    //ADD op xp to remaining character, split evenly amongst the characters
    if (pp2.partyLifeDead == true) {
      var holder1: Double = 0.00
      if ((pp1_count - pp1_deathCounter) == 0) {
        holder1 = pp2.allX_P / pp1_count
        var new_xp: Int = holder1.toInt
        for (i1 <- pp1.p1) {
          if (i1.dead == false) {
            i1.xp += new_xp
          }

        }

      }
      if((pp1_count - pp1_deathCounter) != 0){
        holder1 = pp2.allX_P / (pp1_count-pp1_deathCounter)
        var new_xp: Int = holder1.toInt
        for (i1 <- pp1.p1) {
          if (i1.dead == false) {
            i1.xp += new_xp
          }

        }

      }

      //End of xp addition


    }

  }
}
