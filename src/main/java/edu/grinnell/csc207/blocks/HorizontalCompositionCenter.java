package edu.grinnell.csc207.blocks;


/**
 * The top-aligned horizontal copmosition of two blocks.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
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
   * @param leftBlock
   *   The block on the left.
   *
   * @param rightBlock
   *   The block on the right.
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
   * @exception Exception
   *   if i is outside the range of valid rows.
   */
  public String row(int i) throws Exception {
    int height = Math.max(this.left.height(), this.right.height());
    int leftSpace = height - this.left.height();
    int rightSpace = height - this.right.height();
    int spaces = (height - Math.min(this.left.height(), this.right.height()));

    if ((i < 0) || (i >= this.height())) {
      // Outside of normal bounds
      throw new Exception("Invalid row " + i);
     
      if (i >= spaces && i < spaces + leftSpace && i >= spaces && i < spaces + rightSpace){
        return this.left.row(i) + this.right.row(i);

        return this.left.row(i - spaces) + this.right.row(i - spaces);
      }















    } else if ((i < this.left.height()) && (i < this.right.height())) {
      // Inside both left and right bounds
      return this.left.row(i) + this.right.row(i);
    } else if (i < this.right.height()) {
      // Inside right bounds, outside left bounds
      return " ".repeat(this.left.width()) + this.right.row(i);
    } else {
      // Inside left bounds, outside right bounds
      return this.left.row(i) + " ".repeat(this.right.width());
    } // if/else
  } // row(int)

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
   * @param other
   *   The block to compare to this block.
   *
   * @return true if the two blocks are structurally equivalent and
   *    false otherwise.
   */
  public boolean eqv(AsciiBlock other) {
    return ((other instanceof Grid) && (this.eqv((Grid) other)));
  } // eqv(AsciiBlock)

} // class HorizontalCompositionTop