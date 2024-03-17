/* Robot.java */
/* Generated By:JavaCC: Do not edit this line. Robot.java */
package uniandes.lym.robot.control;

import uniandes.lym.robot.kernel.*;
import uniandes.lym.robot.view.Console;


import java.awt.Point;
import java.io.*;
import java.util.Vector;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Robot implements RobotConstants {


        private RobotWorldDec world;
        private HashMap<String, Integer> variables = new HashMap<String, Integer>();
        public void faceDirection(String direction) {
    switch (direction) {
        case ":north":
            while(!world.facingNorth()) world.turnRight();
            break;
        case ":south":
            while(!world.facingSouth()) world.turnRight();
            break;
        case ":east":
            while(!world.facingEast()) world.turnRight();
            break;
        case ":west":
            while(!world.facingWest()) world.turnRight();
            break;
    }
}


        void setWorld(RobotWorld w) {
                world = (RobotWorldDec) w;
        }

        String salida=new String();

  final public boolean command(Console sistema) throws ParseException {int x, y;
    String salida = new String();
    if (jj_2_18(2)) {
      label_1:
      while (true) {
        if (jj_2_1(2)) {
          jj_consume_token(RIGHT);
          jj_consume_token(47);
          jj_consume_token(48);
world.turnRight();
           salida = "Command: Turn right executed.";
        } else if (jj_2_2(2)) {
          jj_consume_token(MOV);
          jj_consume_token(47);
          x = num();
          jj_consume_token(48);
world.moveForward(x, false);
           salida = "Command: Move forward " + x + " steps executed.";
        } else if (jj_2_3(2)) {
          jj_consume_token(HOP);
          jj_consume_token(47);
          x = num();
          jj_consume_token(48);
world.moveForward(x, true);
           salida = "Command: Jump forward " + x + " steps executed.";
        } else if (jj_2_4(2)) {
          jj_consume_token(GO);
          jj_consume_token(47);
          x = num();
          jj_consume_token(49);
          y = num();
          jj_consume_token(48);
world.setPostion(x,y);
           salida = "Command: Attempt to GO to (" + x + ", " + y + ") received.";
        } else if (jj_2_5(2)) {
          jj_consume_token(POP);
          jj_consume_token(47);
          x = num();
          jj_consume_token(48);
world.popBalloons(x);
           salida = "Command: Pop " + x + " balloons executed.";
        } else if (jj_2_6(2)) {
          jj_consume_token(47);
          jj_consume_token(CMD_SKIP);
          x = num();
          jj_consume_token(48);
world.moveForward(x, true);
           salida = "Command: Jump forward " + x + " steps executed.";
        } else if (jj_2_7(2)) {
          defVar();

        } else if (jj_2_8(2)) {
          asignVar();

        } else if (jj_2_9(2)) {
          turn();

        } else if (jj_2_10(2)) {
          face();

        } else if (jj_2_11(2)) {
          put();

        } else if (jj_2_12(2)) {
          moveDir();

        } else if (jj_2_13(2)) {
          runDirs();

        } else if (jj_2_14(2)) {
          moveFace();

        } else if (jj_2_15(2)) {
          facingCondition();

        } else if (jj_2_16(2)) {
          pick();

        } else {
          jj_consume_token(-1);
          throw new ParseException();
        }
        jj_consume_token(SEMICOLON);
{if ("" != null) return true;}
        if (jj_2_17(2)) {
          ;
        } else {
          break label_1;
        }
      }
    } else if (jj_2_19(2)) {
      jj_consume_token(0);
{if ("" != null) return false;}
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  final public void put() throws ParseException {int f = 0;
    Token x;
    jj_consume_token(47);
    jj_consume_token(PUT);
    if (jj_2_20(2)) {
      x = jj_consume_token(CHIPS);
    } else if (jj_2_21(2)) {
      x = jj_consume_token(BALLOONS);
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    f = num();
    jj_consume_token(48);
if (x.kind == CHIPS) {
            world.putChips(f);
            salida = "Command: Put " + f + " chips executed.";
        } else if (x.kind == BALLOONS) {
            world.putBalloons(f);
            salida = "Command: Put " + f + " balloons executed.";
        }
}

  final public void pick() throws ParseException {int f = 0;
    Token x;
    jj_consume_token(47);
    jj_consume_token(PICK);
    if (jj_2_22(2)) {
      x = jj_consume_token(CHIPS);
    } else if (jj_2_23(2)) {
      x = jj_consume_token(BALLOONS);
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    f = num();
    jj_consume_token(48);
if (x.kind == CHIPS) {
            world.pickChips(f);
        salida = "Command: Picked " + f + " chips executed.";
        } else if (x.kind == BALLOONS) {
            world.grabBalloons(f);
        salida = "Command: Picked " + f + " balloons executed.";
        }
}

  final public void defVar() throws ParseException, Error {Token varName;
    int value;
    jj_consume_token(47);
    jj_consume_token(DEFVAR);
    varName = tokenEspecial();
    value = varOrNum();
    jj_consume_token(48);
String varNameStr = varName.image;
        if (variables.containsKey(varNameStr)) {
            {if (true) throw new Error("Variable " + varNameStr + " is already defined.");}
        }
        variables.put(varNameStr, value);
        salida = "Variable " + varNameStr + " defined with value: " + value;
}

  final public Token tokenEspecial() throws ParseException {Token token;
    if (jj_2_24(2)) {
      token = jj_consume_token(IDENTIFIER);
    } else if (jj_2_25(2)) {
      token = jj_consume_token(RIGHT);
    } else if (jj_2_26(2)) {
      token = jj_consume_token(PUT);
    } else if (jj_2_27(2)) {
      token = jj_consume_token(PICK);
    } else if (jj_2_28(2)) {
      token = jj_consume_token(POP);
    } else if (jj_2_29(2)) {
      token = jj_consume_token(HOP);
    } else if (jj_2_30(2)) {
      token = jj_consume_token(GO);
    } else if (jj_2_31(2)) {
      token = jj_consume_token(CMD_SKIP);
    } else if (jj_2_32(2)) {
      token = jj_consume_token(MOV);
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
{if ("" != null) return token;}
    throw new Error("Missing return statement in function");
}

  final public String identifier() throws ParseException {Token t;
    t = jj_consume_token(IDENTIFIER);
{if ("" != null) return t.image;}
    throw new Error("Missing return statement in function");
}

  final public int varOrNum() throws ParseException, Error {int total = 0;
    String variable;
    if (jj_2_33(2)) {
      jj_consume_token(IDENTIFIER);
variable = token.image;
        if (variables.containsKey(variable)) {
            total = variables.get(variable);
        } else {
            {if (true) throw new Error("La variable '" + variable + "' no existe.");}
        }
        {if ("" != null) return total;}
    } else if (jj_2_34(2)) {
      jj_consume_token(NUM);
try {
            total = Integer.parseInt(token.image);
        } catch (NumberFormatException ee) {
            {if (true) throw new Error("Number out of bounds: " + token.image + "!!");}
        }
        {if ("" != null) return total;}
    } else {
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
}

  final public void asignVar() throws ParseException {Token varName;
    int value;
    jj_consume_token(47);
    jj_consume_token(ASSIGN);
    varName = tokenEspecial();
    value = varOrNum();
    jj_consume_token(48);
String varNameStr = varName.image;
        if (variables.containsKey(varNameStr)) {
            {if (true) throw new Error("Variable " + varNameStr + " is already defined.");}
        }
        variables.put(varNameStr, value);
        salida = "Variable " + varNameStr + " defined with value: " + value;
}

  final public void turn() throws ParseException {Token dir;
    jj_consume_token(47);
    jj_consume_token(TURN);
    dir = jj_consume_token(DIRECTION);
    jj_consume_token(48);
if (dir.image.equals(":left")) {
    world.turnRight();
    world.turnRight();
    world.turnRight();
} else if (dir.image.equals(":right")) {
    world.turnRight();
} else if (dir.image.equals(":around")) {
    world.turnRight();
    world.turnRight();
  }
}

  final public void face() throws ParseException {Token direction;
    jj_consume_token(47);
    jj_consume_token(FACE);
    direction = jj_consume_token(ORIENTATION);
    jj_consume_token(48);
switch (direction.image) {
            case ":north":
                faceDirection(RobotWorld.NORTH);
                break;
            case ":south":
                faceDirection(RobotWorld.SOUTH);
                break;
            case ":east":
                faceDirection(RobotWorld.EAST);
                break;
            case ":west":
                faceDirection(RobotWorld.WEST);
                break;
        }
}

  final public void faceDirection(int targetDirection) throws ParseException {
while(true) {
            if ((targetDirection == RobotWorld.NORTH && world.facingNorth()) ||
                (targetDirection == RobotWorld.SOUTH && world.facingSouth()) ||
                (targetDirection == RobotWorld.EAST && world.facingEast()) ||
                (targetDirection == RobotWorld.WEST && world.facingWest())) {
                break;
            } else {
                world.turnRight();
            }
        }
}

  final public void moveDir() throws ParseException {int n = 0;
    Token dir;
    int originalFacing;
    jj_consume_token(47);
    jj_consume_token(MOVEDIR);
    n = num();
    dir = jj_consume_token(DIRECTION);
    jj_consume_token(48);
originalFacing = world.getFacing();
        switch (dir.image) {
            case ":front":

                break;
            case ":right":

                world.turnRight();
                world.moveForward(n, false);
                restoreOriginalFacing(originalFacing);
                break;
            case ":left":

                world.turnRight();
                world.turnRight();
                world.turnRight();
                world.moveForward(n, false);
                restoreOriginalFacing(originalFacing);
                break;
            case ":back":

                world.turnRight();
                world.turnRight();
                world.moveForward(n, false);
                restoreOriginalFacing(originalFacing);
                break;
        }
}

  final public void restoreOriginalFacing(int originalFacing) throws ParseException {
while (world.getFacing() != originalFacing) {
            world.turnRight();
        }
}

  final public void moveFace() throws ParseException {int steps;
    Token direction;
    Token stepsToken;
    jj_consume_token(47);
    jj_consume_token(MOVEFACE);
    stepsToken = jj_consume_token(NUM);
    direction = jj_consume_token(ORIENTATION);
    jj_consume_token(48);
steps = Integer.parseInt(stepsToken.image);


        faceDirection(direction.image);


        for(int i = 0; i < steps; i++) {
            world.moveForward(1, false);
        }
}

  final public void runDirs() throws ParseException {List<Token> directions = new ArrayList<>();
    Token dir;
    int originalFacing;
    jj_consume_token(47);
    jj_consume_token(RUNDIRS);
    dir = jj_consume_token(DIRECTION);
directions.add(dir);
    label_2:
    while (true) {
      if (jj_2_35(2)) {
        ;
      } else {
        break label_2;
      }
      dir = jj_consume_token(DIRECTION);
directions.add(dir);
    }
    jj_consume_token(48);
originalFacing = world.getFacing();


        for (Token direction : directions) {
            switch (direction.image) {
                case ":front":
                    world.moveForward(1, false);
                    break;
                case ":right":
                    world.turnRight();
                    world.moveForward(1, false);
                    world.turnRight(); world.turnRight(); world.turnRight();
                    break;
                case ":left":
                    world.turnRight(); world.turnRight(); world.turnRight();
                    world.moveForward(1, false);
                    world.turnRight();
                    break;
                case ":back":
                    world.turnRight(); world.turnRight();
                    world.moveForward(1, false);
                    world.turnRight(); world.turnRight();
                    break;
            }
        }


        while (world.getFacing() != originalFacing) {
            world.turnRight();
        }
}

  final public void nullCommand() throws ParseException {
    jj_consume_token(47);
    jj_consume_token(NULL);
    jj_consume_token(48);
}

  final public boolean facingCondition() throws ParseException {Token direction;
    jj_consume_token(47);
    jj_consume_token(FACING);
    jj_consume_token(50);
    direction = jj_consume_token(ORIENTATION);
    jj_consume_token(48);
switch(direction.image)
        {
            case ":north":
                {if ("" != null) return world.facingNorth();}
            case ":south":
                {if ("" != null) return world.facingSouth();}
            case ":east":
                {if ("" != null) return world.facingEast();}
            case ":west":
                {if ("" != null) return world.facingWest();}
            default:
                {if (true) throw new ParseException("Unknown direction: " + direction.image);}
        }
    throw new Error("Missing return statement in function");
}

/**
	 * Unsigned decimal number
	 * @return the corresponding value of the string
	 * @error  corresponding value is too larges
	 */
  final public 
        int num() throws ParseException, Error {int total=1;
    jj_consume_token(NUM);
try
                        {
                                total = Integer.parseInt(token.image);
                        }
                        catch (NumberFormatException ee)
                        {
                                {if (true) throw new Error("Number out of bounds: "+token.image+" !!");}
                        }
                        {if ("" != null) return total;}
    throw new Error("Missing return statement in function");
}

  private boolean jj_2_1(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_1()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_2()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_3()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_4()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_2_5(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_5()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(4, xla); }
  }

  private boolean jj_2_6(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_6()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(5, xla); }
  }

  private boolean jj_2_7(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_7()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(6, xla); }
  }

  private boolean jj_2_8(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_8()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(7, xla); }
  }

  private boolean jj_2_9(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_9()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(8, xla); }
  }

  private boolean jj_2_10(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_10()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(9, xla); }
  }

  private boolean jj_2_11(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_11()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(10, xla); }
  }

  private boolean jj_2_12(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_12()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(11, xla); }
  }

  private boolean jj_2_13(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_13()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(12, xla); }
  }

  private boolean jj_2_14(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_14()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(13, xla); }
  }

  private boolean jj_2_15(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_15()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(14, xla); }
  }

  private boolean jj_2_16(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_16()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(15, xla); }
  }

  private boolean jj_2_17(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_17()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(16, xla); }
  }

  private boolean jj_2_18(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_18()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(17, xla); }
  }

  private boolean jj_2_19(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_19()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(18, xla); }
  }

  private boolean jj_2_20(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_20()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(19, xla); }
  }

  private boolean jj_2_21(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_21()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(20, xla); }
  }

  private boolean jj_2_22(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_22()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(21, xla); }
  }

  private boolean jj_2_23(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_23()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(22, xla); }
  }

  private boolean jj_2_24(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_24()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(23, xla); }
  }

  private boolean jj_2_25(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_25()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(24, xla); }
  }

  private boolean jj_2_26(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_26()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(25, xla); }
  }

  private boolean jj_2_27(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_27()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(26, xla); }
  }

  private boolean jj_2_28(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_28()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(27, xla); }
  }

  private boolean jj_2_29(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_29()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(28, xla); }
  }

  private boolean jj_2_30(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_30()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(29, xla); }
  }

  private boolean jj_2_31(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_31()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(30, xla); }
  }

  private boolean jj_2_32(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_32()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(31, xla); }
  }

  private boolean jj_2_33(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_33()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(32, xla); }
  }

  private boolean jj_2_34(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_34()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(33, xla); }
  }

  private boolean jj_2_35(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return (!jj_3_35()); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(34, xla); }
  }

  private boolean jj_3_26()
 {
    if (jj_scan_token(PUT)) return true;
    return false;
  }

  private boolean jj_3_25()
 {
    if (jj_scan_token(RIGHT)) return true;
    return false;
  }

  private boolean jj_3_24()
 {
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  private boolean jj_3_8()
 {
    if (jj_3R_asignVar_324_3_4()) return true;
    return false;
  }

  private boolean jj_3_7()
 {
    if (jj_3R_defVar_257_5_3()) return true;
    return false;
  }

  private boolean jj_3_6()
 {
    if (jj_scan_token(47)) return true;
    if (jj_scan_token(CMD_SKIP)) return true;
    return false;
  }

  private boolean jj_3_5()
 {
    if (jj_scan_token(POP)) return true;
    if (jj_scan_token(47)) return true;
    return false;
  }

  private boolean jj_3R_moveFace_454_5_10()
 {
    if (jj_scan_token(47)) return true;
    if (jj_scan_token(MOVEFACE)) return true;
    return false;
  }

  private boolean jj_3R_face_357_5_6()
 {
    if (jj_scan_token(47)) return true;
    if (jj_scan_token(FACE)) return true;
    return false;
  }

  private boolean jj_3_23()
 {
    if (jj_scan_token(BALLOONS)) return true;
    return false;
  }

  private boolean jj_3_4()
 {
    if (jj_scan_token(GO)) return true;
    if (jj_scan_token(47)) return true;
    return false;
  }

  private boolean jj_3R_defVar_257_5_3()
 {
    if (jj_scan_token(47)) return true;
    if (jj_scan_token(DEFVAR)) return true;
    return false;
  }

  private boolean jj_3_3()
 {
    if (jj_scan_token(HOP)) return true;
    if (jj_scan_token(47)) return true;
    return false;
  }

  private boolean jj_3_2()
 {
    if (jj_scan_token(MOV)) return true;
    if (jj_scan_token(47)) return true;
    return false;
  }

  private boolean jj_3_22()
 {
    if (jj_scan_token(CHIPS)) return true;
    return false;
  }

  private boolean jj_3_1()
 {
    if (jj_scan_token(RIGHT)) return true;
    if (jj_scan_token(47)) return true;
    return false;
  }

  private boolean jj_3_35()
 {
    if (jj_scan_token(DIRECTION)) return true;
    return false;
  }

  private boolean jj_3_17()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3_1()) {
    jj_scanpos = xsp;
    if (jj_3_2()) {
    jj_scanpos = xsp;
    if (jj_3_3()) {
    jj_scanpos = xsp;
    if (jj_3_4()) {
    jj_scanpos = xsp;
    if (jj_3_5()) {
    jj_scanpos = xsp;
    if (jj_3_6()) {
    jj_scanpos = xsp;
    if (jj_3_7()) {
    jj_scanpos = xsp;
    if (jj_3_8()) {
    jj_scanpos = xsp;
    if (jj_3_9()) {
    jj_scanpos = xsp;
    if (jj_3_10()) {
    jj_scanpos = xsp;
    if (jj_3_11()) {
    jj_scanpos = xsp;
    if (jj_3_12()) {
    jj_scanpos = xsp;
    if (jj_3_13()) {
    jj_scanpos = xsp;
    if (jj_3_14()) {
    jj_scanpos = xsp;
    if (jj_3_15()) {
    jj_scanpos = xsp;
    if (jj_3_16()) return true;
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_turn_339_5_5()
 {
    if (jj_scan_token(47)) return true;
    if (jj_scan_token(TURN)) return true;
    return false;
  }

  private boolean jj_3_21()
 {
    if (jj_scan_token(BALLOONS)) return true;
    return false;
  }

  private boolean jj_3_18()
 {
    Token xsp;
    if (jj_3_17()) return true;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3_17()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_facingCondition_524_5_11()
 {
    if (jj_scan_token(47)) return true;
    if (jj_scan_token(FACING)) return true;
    return false;
  }

  private boolean jj_3R_pick_238_5_12()
 {
    if (jj_scan_token(47)) return true;
    if (jj_scan_token(PICK)) return true;
    return false;
  }

  private boolean jj_3_20()
 {
    if (jj_scan_token(CHIPS)) return true;
    return false;
  }

  private boolean jj_3R_asignVar_324_3_4()
 {
    if (jj_scan_token(47)) return true;
    if (jj_scan_token(ASSIGN)) return true;
    return false;
  }

  private boolean jj_3R_put_221_5_7()
 {
    if (jj_scan_token(47)) return true;
    if (jj_scan_token(PUT)) return true;
    return false;
  }

  private boolean jj_3_34()
 {
    if (jj_scan_token(NUM)) return true;
    return false;
  }

  private boolean jj_3R_moveDir_403_5_8()
 {
    if (jj_scan_token(47)) return true;
    if (jj_scan_token(MOVEDIR)) return true;
    return false;
  }

  private boolean jj_3_19()
 {
    if (jj_scan_token(0)) return true;
    return false;
  }

  private boolean jj_3_16()
 {
    if (jj_3R_pick_238_5_12()) return true;
    return false;
  }

  private boolean jj_3_33()
 {
    if (jj_scan_token(IDENTIFIER)) return true;
    return false;
  }

  private boolean jj_3_15()
 {
    if (jj_3R_facingCondition_524_5_11()) return true;
    return false;
  }

  private boolean jj_3_14()
 {
    if (jj_3R_moveFace_454_5_10()) return true;
    return false;
  }

  private boolean jj_3_13()
 {
    if (jj_3R_runDirs_475_4_9()) return true;
    return false;
  }

  private boolean jj_3_12()
 {
    if (jj_3R_moveDir_403_5_8()) return true;
    return false;
  }

  private boolean jj_3_11()
 {
    if (jj_3R_put_221_5_7()) return true;
    return false;
  }

  private boolean jj_3_32()
 {
    if (jj_scan_token(MOV)) return true;
    return false;
  }

  private boolean jj_3R_runDirs_475_4_9()
 {
    if (jj_scan_token(47)) return true;
    if (jj_scan_token(RUNDIRS)) return true;
    return false;
  }

  private boolean jj_3_31()
 {
    if (jj_scan_token(CMD_SKIP)) return true;
    return false;
  }

  private boolean jj_3_10()
 {
    if (jj_3R_face_357_5_6()) return true;
    return false;
  }

  private boolean jj_3_30()
 {
    if (jj_scan_token(GO)) return true;
    return false;
  }

  private boolean jj_3_29()
 {
    if (jj_scan_token(HOP)) return true;
    return false;
  }

  private boolean jj_3_28()
 {
    if (jj_scan_token(POP)) return true;
    return false;
  }

  private boolean jj_3_9()
 {
    if (jj_3R_turn_339_5_5()) return true;
    return false;
  }

  private boolean jj_3_27()
 {
    if (jj_scan_token(PICK)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public RobotTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[0];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
	   jj_la1_init_0();
	   jj_la1_init_1();
	}
	private static void jj_la1_init_0() {
	   jj_la1_0 = new int[] {};
	}
	private static void jj_la1_init_1() {
	   jj_la1_1 = new int[] {};
	}
  final private JJCalls[] jj_2_rtns = new JJCalls[35];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Robot(java.io.InputStream stream) {
	  this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Robot(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source = new RobotTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
	  ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
	 try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < 0; i++) jj_la1[i] = -1;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Robot(java.io.Reader stream) {
	 jj_input_stream = new SimpleCharStream(stream, 1, 1);
	 token_source = new RobotTokenManager(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
	if (jj_input_stream == null) {
	   jj_input_stream = new SimpleCharStream(stream, 1, 1);
	} else {
	   jj_input_stream.ReInit(stream, 1, 1);
	}
	if (token_source == null) {
 token_source = new RobotTokenManager(jj_input_stream);
	}

	 token_source.ReInit(jj_input_stream);
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Robot(RobotTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(RobotTokenManager tm) {
	 token_source = tm;
	 token = new Token();
	 jj_ntk = -1;
	 jj_gen = 0;
	 for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
	 Token oldToken;
	 if ((oldToken = token).next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 if (token.kind == kind) {
	   jj_gen++;
	   if (++jj_gc > 100) {
		 jj_gc = 0;
		 for (int i = 0; i < jj_2_rtns.length; i++) {
		   JJCalls c = jj_2_rtns[i];
		   while (c != null) {
			 if (c.gen < jj_gen) c.first = null;
			 c = c.next;
		   }
		 }
	   }
	   return token;
	 }
	 token = oldToken;
	 jj_kind = kind;
	 throw generateParseException();
  }

  @SuppressWarnings("serial")
  static private final class LookaheadSuccess extends java.lang.Error {
    @Override
    public Throwable fillInStackTrace() {
      return this;
    }
  }
  static private final LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
	 if (jj_scanpos == jj_lastpos) {
	   jj_la--;
	   if (jj_scanpos.next == null) {
		 jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
	   } else {
		 jj_lastpos = jj_scanpos = jj_scanpos.next;
	   }
	 } else {
	   jj_scanpos = jj_scanpos.next;
	 }
	 if (jj_rescan) {
	   int i = 0; Token tok = token;
	   while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
	   if (tok != null) jj_add_error_token(kind, i);
	 }
	 if (jj_scanpos.kind != kind) return true;
	 if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
	 return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
	 if (token.next != null) token = token.next;
	 else token = token.next = token_source.getNextToken();
	 jj_ntk = -1;
	 jj_gen++;
	 return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
	 Token t = token;
	 for (int i = 0; i < index; i++) {
	   if (t.next != null) t = t.next;
	   else t = t.next = token_source.getNextToken();
	 }
	 return t;
  }

  private int jj_ntk_f() {
	 if ((jj_nt=token.next) == null)
	   return (jj_ntk = (token.next=token_source.getNextToken()).kind);
	 else
	   return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
	 if (pos >= 100) {
		return;
	 }

	 if (pos == jj_endpos + 1) {
	   jj_lasttokens[jj_endpos++] = kind;
	 } else if (jj_endpos != 0) {
	   jj_expentry = new int[jj_endpos];

	   for (int i = 0; i < jj_endpos; i++) {
		 jj_expentry[i] = jj_lasttokens[i];
	   }

	   for (int[] oldentry : jj_expentries) {
		 if (oldentry.length == jj_expentry.length) {
		   boolean isMatched = true;

		   for (int i = 0; i < jj_expentry.length; i++) {
			 if (oldentry[i] != jj_expentry[i]) {
			   isMatched = false;
			   break;
			 }

		   }
		   if (isMatched) {
			 jj_expentries.add(jj_expentry);
			 break;
		   }
		 }
	   }

	   if (pos != 0) {
		 jj_lasttokens[(jj_endpos = pos) - 1] = kind;
	   }
	 }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
	 jj_expentries.clear();
	 boolean[] la1tokens = new boolean[51];
	 if (jj_kind >= 0) {
	   la1tokens[jj_kind] = true;
	   jj_kind = -1;
	 }
	 for (int i = 0; i < 0; i++) {
	   if (jj_la1[i] == jj_gen) {
		 for (int j = 0; j < 32; j++) {
		   if ((jj_la1_0[i] & (1<<j)) != 0) {
			 la1tokens[j] = true;
		   }
		   if ((jj_la1_1[i] & (1<<j)) != 0) {
			 la1tokens[32+j] = true;
		   }
		 }
	   }
	 }
	 for (int i = 0; i < 51; i++) {
	   if (la1tokens[i]) {
		 jj_expentry = new int[1];
		 jj_expentry[0] = i;
		 jj_expentries.add(jj_expentry);
	   }
	 }
	 jj_endpos = 0;
	 jj_rescan_token();
	 jj_add_error_token(0, 0);
	 int[][] exptokseq = new int[jj_expentries.size()][];
	 for (int i = 0; i < jj_expentries.size(); i++) {
	   exptokseq[i] = jj_expentries.get(i);
	 }
	 return new ParseException(token, exptokseq, tokenImage);
  }

  private boolean trace_enabled;

/** Trace enabled. */
  final public boolean trace_enabled() {
	 return trace_enabled;
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
	 jj_rescan = true;
	 for (int i = 0; i < 35; i++) {
	   try {
		 JJCalls p = jj_2_rtns[i];

		 do {
		   if (p.gen > jj_gen) {
			 jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
			 switch (i) {
			   case 0: jj_3_1(); break;
			   case 1: jj_3_2(); break;
			   case 2: jj_3_3(); break;
			   case 3: jj_3_4(); break;
			   case 4: jj_3_5(); break;
			   case 5: jj_3_6(); break;
			   case 6: jj_3_7(); break;
			   case 7: jj_3_8(); break;
			   case 8: jj_3_9(); break;
			   case 9: jj_3_10(); break;
			   case 10: jj_3_11(); break;
			   case 11: jj_3_12(); break;
			   case 12: jj_3_13(); break;
			   case 13: jj_3_14(); break;
			   case 14: jj_3_15(); break;
			   case 15: jj_3_16(); break;
			   case 16: jj_3_17(); break;
			   case 17: jj_3_18(); break;
			   case 18: jj_3_19(); break;
			   case 19: jj_3_20(); break;
			   case 20: jj_3_21(); break;
			   case 21: jj_3_22(); break;
			   case 22: jj_3_23(); break;
			   case 23: jj_3_24(); break;
			   case 24: jj_3_25(); break;
			   case 25: jj_3_26(); break;
			   case 26: jj_3_27(); break;
			   case 27: jj_3_28(); break;
			   case 28: jj_3_29(); break;
			   case 29: jj_3_30(); break;
			   case 30: jj_3_31(); break;
			   case 31: jj_3_32(); break;
			   case 32: jj_3_33(); break;
			   case 33: jj_3_34(); break;
			   case 34: jj_3_35(); break;
			 }
		   }
		   p = p.next;
		 } while (p != null);

		 } catch(LookaheadSuccess ls) { }
	 }
	 jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
	 JJCalls p = jj_2_rtns[index];
	 while (p.gen > jj_gen) {
	   if (p.next == null) { p = p.next = new JJCalls(); break; }
	   p = p.next;
	 }

	 p.gen = jj_gen + xla - jj_la; 
	 p.first = token;
	 p.arg = xla;
  }

  static final class JJCalls {
	 int gen;
	 Token first;
	 int arg;
	 JJCalls next;
  }

}
