package edu.grinnell.csc207.blocks;


/**
 * The top-aligned horizontal copmosition of two blocks.
 *
 * @author Samuel A. Rebelsky
 * @author Mitch Paiva
 * @author Shiela Muligande
 *
 */
public class HorizontalCompositionCenter implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The left block.
   */
  AsciiBlock left;

  /**
   * The right block.
   */
  AsciiBlock right;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a Horizontal Composition.
   *
   * @param leftBlock The block on the left.
   *
   * @param rightBlock The block on the right.
   */
  public HorizontalCompositionCenter(AsciiBlock leftBlock, AsciiBlock rightBlock) {
    this.left = leftBlock;
    this.right = rightBlock;
  } // HorizontalCompositionCenter

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
   * @exception Exception if i is outside the range of valid rows.
   */

  public String row(int i) throws Exception {
    int height = Math.max(this.left.height(), this.right.height());

    int leftSpace = (height - this.left.height()) / 2;
    int rightSpace = (height - this.right.height()) / 2;
    int spaces = (height - Math.min(this.left.height(), this.right.height()));

    if ((i < 0) || (i >= this.height())) {
      // Outside of normal bounds
      throw new Exception("Invalid row " + i);
    } // if statement

    String leftOne;
    if (i >= leftSpace && i < leftSpace + this.left.height()) {
      leftOne = this.left.row(i - leftSpace);
    } else {
      leftOne = " ".repeat(this.left.width());
    } // else statement

    String rightOne;
    if (i >= rightSpace && i < rightSpace + this.right.height()) {
      rightOne = this.right.row(i - rightSpace);
    } else {
      rightOne = " ".repeat(this.right.width());
    } // else statement
    return leftOne + rightOne;
  } //String row(int i)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return Math.max(this.left.height(), this.right.height());
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    return this.left.width() + this.right.width();
  } // width()

  /**
   * Determine if another block is structurally equivalent to this block.
   *
   * @param other The block to compare to this block.
   *
   * @return true if the two blocks are structurally equivalent and false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    if (!(other instanceof HorizontalCompositionCenter)) {
      return false;
    } // if statement
    HorizontalCompositionCenter otherCenter = (HorizontalCompositionCenter) other;
    return this.left.eqv(otherCenter.left) && this.right.eqv(otherCenter.right);
  } // eqv(AsciiBlock)

} // class HorizontalCompositionTop
