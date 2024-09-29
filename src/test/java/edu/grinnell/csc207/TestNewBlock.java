package edu.grinnell.csc207;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import edu.grinnell.csc207.blocks.AsciiBlock;
import edu.grinnell.csc207.blocks.DiagonalFlip;
import edu.grinnell.csc207.blocks.Empty;
import edu.grinnell.csc207.blocks.HAlignment;
import edu.grinnell.csc207.blocks.HComp;
import edu.grinnell.csc207.blocks.HFlip;
import edu.grinnell.csc207.blocks.Line;
import edu.grinnell.csc207.blocks.VAlignment;
import edu.grinnell.csc207.blocks.VComp;
import edu.grinnell.csc207.blocks.VFlip;

/**
 * Tests of the new block.
 */
public class TestNewBlock {
  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * DiagonalFlip of the empty block.
   */
  @Test
  public void testDiagonalFlipEmpty() {
    AsciiBlock empty = new DiagonalFlip(new Empty());
    assertEquals(0, empty.width(), "Passed");
    assertEquals(0, empty.height(), "Passed");
  } // testHFlipEmpty()

  /**
   * DiagonalFlip of the empty block.
   */
  @Test
  public void testDiagonalLine() {
    AsciiBlock Test = new Line("Sheilla");

    AsciiBlock Diagonalled = new DiagonalFlip(Test);
    assertEquals(7, Diagonalled.width(), "Correct width for Sheilla");
    assertEquals(1, Diagonalled.height(), "correct height for Sheilla");
    assertEquals("alliehS\n", TestUtils.toString(Diagonalled),
        "M: Correct contents for hflipped hello");

  }

  /**
   * DiagonalFlip of the empty block.
   */
  @Test
  public void testDiagonalParagraph() {
    AsciiBlock line1 = new Line("Hi Everyone");
    AsciiBlock line2 = new Line("this is a test.");
    AsciiBlock line3 = new Line("how are you?");

   AsciiBlock paragraph = new VComp(HAlignment.RIGHT,new AsciiBlock[] {line1, line2, line3});
    

    AsciiBlock diagonalParagraph = new DiagonalFlip(paragraph);
    assertEquals(15, diagonalParagraph.width(), "Correct width for a paragraph");
    assertEquals(3, diagonalParagraph.height(), "correct height for a paragraph");
    assertEquals("?uoy era woh   \n"
               + ".tset a si siht\n"
               + "enoyrevE iH    \n", TestUtils.toString(diagonalParagraph), "correct contents for a flipped paragraph.");
  
}
}



// @Test
// public void testHFlipStuff() {
//   AsciiBlock abcd = 
//       new VComp(HAlignment.LEFT, new AsciiBlock[] { new Line("alfa"), 
//           new Line("bravo"), new Line("charlie"), new Line("delta") });

//   AsciiBlock flipped = new HFlip(abcd);
//   assertEquals(7, flipped.width(),
//       "M: Correct width for hflipped abcd");
//   assertEquals(4, flipped.height(),
//       "M: Correct height for hflipped abcd");
//   assertEquals("   afla\n  ovarb\neilrahc\n  atled\n",
//       TestUtils.toString(flipped),
//       "M: Correct contents for hflipped abcd");

//   AsciiBlock flipflop = new HFlip(flipped);
//   assertEquals(7, flipflop.width(),
//       "M: Correct width for doubly hflipped abcd");
//   assertEquals(4, flipflop.height(),
//       "M: Correct height for doubly hflipped abcd");
//   assertEquals("alfa   \nbravo  \ncharlie\ndelta  \n",
//       TestUtils.toString(flipflop),
//       "M: Correct contents for doubly hflipped abcd");

//   AsciiBlock mirror = 
//       new HComp(VAlignment.TOP, new AsciiBlock[] { flipped, abcd });
//   assertEquals(14, mirror.width(),
//       "E: Correct width for mirrored text");
//   assertEquals(4, mirror.height(),
//       "E: Correct height for mirrored text");
//   assertEquals(
//       "   aflaalfa   \n  ovarbbravo  \neilrahccharlie\n  atleddelta  \n",
//       TestUtils.toString(mirror),
//       "E: Correct contents for mirrored text");
  
//   AsciiBlock rorrim = new HFlip(mirror);
//   assertEquals(mirror.width(), rorrim.width(),
//       "E: Correct width for hflipped mirror");
//   assertEquals(mirror.height(), rorrim.height(),
//       "E: Correct height for hflipped mirror");
//   assertEquals(TestUtils.toString(mirror), TestUtils.toString(rorrim),
//       "E: Correct contents for hflipped mirror");
// } // testHFlipStuff

