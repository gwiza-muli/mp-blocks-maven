package edu.grinnell.csc207.blocks;

public class VerticalCompositionCenter implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The left block.
   */
  AsciiBlock above;

  /**
   * The right block.
   */
  AsciiBlock below;

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
  public VerticalCompositionCenter(AsciiBlock aboveBlock, AsciiBlock belowBlock) {
    this.above = aboveBlock;
    this.below = belowBlock;
  } // VerticalCompositionCenter


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

   public String row (int i) throws Exception{
    if ((i < 0) || (i >= this.height())) {
      // Outside of normal bounds
      throw new Exception("Invalid row " + i);
    } else if (i < this.above.height()){
      String aboveRow = this.above.row(i);
      int offset = this.width() - this.above.width();
      int leftSpace = offset / 2;
      int rightSpace = offset - leftSpace;
      return " ".repeat(leftSpace) + aboveRow + " ".repeat(rightSpace);

    } else {
      int belowIndex = i - this.above.height();
      String belowRow = this.below.row(belowIndex);
      int offset = this.width() - this.below.width();
      int leftSpace = offset / 2;
      int rightSpace = offset - leftSpace;
      return " ".repeat(leftSpace) + belowRow + " ".repeat(rightSpace);
    
    }
   }
 
  
  public int height() {
    return this.above.height() + this.below.height();
  }
 

  public int width() {
    return Math.max(this.above.width(), this.below.width());
  }
 

  public boolean eqv(AsciiBlock other) {
    if(!(other instanceof HorizontalCompositionCenter)) {
      return false;
    }
    VerticalCompositionCenter otherCenter = (VerticalCompositionCenter) other; 
    return this.above.eqv(otherCenter.above) && this.below.eqv(otherCenter.below);
  } // eqv(AsciiBlock)

}
