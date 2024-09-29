package edu.grinnell.csc207.blocks;
// Credit: Alex Cyphers who worked on the Subtype Polymorphism lab with Sheilla. we use that lab.


/**
 * A text block surrounded by a single letter.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class Surrounded implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The stuff in the box.
   */
  AsciiBlock contents;


  /**
   * The character we put around the box.
   */
  String surroundChar;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new block with the specified contents.
   *
   * @param blockContents The contents of the block.
   *
   * @param theChar The character that we use to surround the block.
   */
  public Surrounded(AsciiBlock blockContents, char theChar) {
    this.contents = blockContents;
    this.surroundChar = Character.toString(theChar);
  } // Surrounded(AsciiBlock)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   *
   * @param i the number of the row
   *
   * @return row i.
   *
   * @exception Exception If the row is invalid.
   */
  public String row(int i) throws Exception {
    int h = this.contents.height();
    if (i == 0) {
      // The top of the box
      return this.surroundChar + this.surroundChar.repeat(this.contents.width())
          + this.surroundChar;
    } else if (i == h + 1) {
      // The bottom of the box
      return this.surroundChar + this.surroundChar.repeat(this.contents.width())
          + this.surroundChar;
    } else if ((i > 0) && (i <= h)) {
      // Stuff within the box
      return this.surroundChar + this.contents.row(i - 1) + this.surroundChar;
    } else {
      throw new Exception("Invalid row " + i);
    } // if/else
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return 2 + this.contents.height(); // STUB
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    return 2 + this.contents.width(); // STUB
  } // width()

   /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other The block to compare to this block.
   *
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    return ((other instanceof Surrounded) && (this.eqv((Surrounded) other)));
  } // eqv(AsciiBlock)


  /**
   * Determine if this Surrounded is structurally equivalent to another.
   *
   * @param other The block to compare to this block.
   *
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */

  public boolean eqv(Surrounded other) {
    return (this.width() == other.width()) && (this.height() == other.height())
        && (this.surroundChar.equals(other.surroundChar));
  } // eqv(HComp)
















  // /**
  //  * Determine if another block is structurally equivalent to this block.
  //  *
  //  * @param other The block to compare to this block.
  //  *
  //  * @return true if the two blocks are structurally equivalent and false otherwise.
  //  */
  // public boolean eqv(AsciiBlock other) {
  //   int h = this.contents.height();
  //   int h2 = other.height();
  //   int h3;
  //   if (this.contents.height() > other.height()) {
  //     h3 = this.contents.height();
  //   } else {
  //     h3 = other.height();
  //   }

  //   for (int i = 0; i < h3; i++) {
  //     try {
  //       if (!(this.contents.row(i).equals(other.row(i)))) {
  //         return false;
  //       }
  //     } catch (Exception e) {
  //       return false;
  //     } // try-catch
  //   } // for

  //   return true;
  // } // eqv(AsciiBlock)
} // class Surrounded
