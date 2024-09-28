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

    int leftSpace = (height - this.left.height() ) / 2;
    int rightSpace = (height - this.right.height()) / 2;
    int spaces = (height - Math.min(this.left.height(), this.right.height()));

    if ((i < 0) || (i >= this.height())) {
      // Outside of normal bounds
      throw new Exception("Invalid row " + i);
    }
    
    String left;
    if (i >= leftSpace && i < leftSpace + this.left.height()) {
       left = this.left.row(i - leftSpace);
    } else {
      left = " ".repeat(this.right.width());
    }

    String right;
    if (i >= rightSpace && i < rightSpace + this.right.height()) {
       right = this.right.row(i - rightSpace);
    } else {
      right = " ".repeat(this.right.width());
    }


   return left + right;
  }






  // public String row(int i) throws Exception {
  //   int height = Math.max(this.left.height(), this.right.height());
  //   int leftSpace = height - this.left.height();
  //   int rightSpace = height - this.right.height();
  //   int spaces = (height - Math.min(this.left.height(), this.right.height()));

  //   if ((i < 0) || (i >= this.height())) {
  //     // Outside of normal bounds
  //     throw new Exception("Invalid row " + i);
  //   }
  //   if (i >= spaces && i < spaces + leftSpace && i >= spaces && i < spaces + rightSpace) {
  //     return this.left.row(i - spaces) + this.right.row(i - spaces);
  //   }
  //   else if (i >= spaces && i < spaces + leftSpace){
  //     return this.left.row(i - spaces) + " ".repeat(this.right.width());
  //   }
  //   else if (i >= spaces && i < spaces + rightSpace){
  //     return " ".repeat(this.left.width()) + this.right.row(i - spaces);
  //   } else {
  //     return " ".repeat(this.width());
  //   }
  // }

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
    if(!(other instanceof HorizontalCompositionCenter)) {
      return false;
    }
    HorizontalCompositionCenter otherCenter = (HorizontalCompositionCenter) other; 
    return this.left.eqv(otherCenter.left) && this.right.eqv(otherCenter.right);
  } // eqv(AsciiBlock)

} // class HorizontalCompositionTop
