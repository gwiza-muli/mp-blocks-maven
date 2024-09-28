package edu.grinnell.csc207.blocks;

import java.util.Arrays;

/**
 * The vertical composition of blocks.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 * @author Your Name Here
 */
public class VComp implements AsciiBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The blocks.
   */
  AsciiBlock[] blocks;

  /**
   * How the blocks are aligned.
   */
  VAlignment align;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a vertical composition of two blocks.
   *
   * @param alignment
   *   The way in which the blocks should be aligned.
   * @param topBlock
   *   The block on the top.
   * @param bottomBlock
   *   The block on the bottom.
   */
  public VComp(VAlignment alignment, AsciiBlock topBlock,
      AsciiBlock bottomBlock) {
    this.align = alignment;
    this.blocks = new AsciiBlock[] {topBlock, bottomBlock};
  } // VComp(VAlignment, AsciiBlock, AsciiBlock)

  /**
   * Build a vertical composition of multiple blocks.
   *
   * @param alignment
   *   The alignment of the blocks.
   * @param blocksToCompose
   *   The blocks we will be composing.
   */
  public VComp(VAlignment alignment, AsciiBlock[] blocksToCompose) {
    this.align = alignment;
    this.blocks = Arrays.copyOf(blocksToCompose, blocksToCompose.length);
  } // VComp(VAlignment, AsciiBLOCK[])
  public AsciiBlock reduce() {
    AsciiBlock accumulator;
      if (this.align == VAlignment.TOP) {
        accumulator = new HorizontalCompositionTop(this.blocks[0], this.blocks[1]);
      } else if (this.align == VAlignment.CENTER) {
        accumulator = new HorizontalCompositionCenter(this.blocks[0], this.blocks[1]);
      } else if (this.align == VAlignment.BOTTOM) {
        accumulator = new HorizontalCompositionBottom(this.blocks[0], this.blocks[1]);
      } else {
        throw new IllegalArgumentException("Invalid alignment");
      }


      for (int x = 2; x < this.blocks.length; x++) {
        if (this.align == HAlignment.LEFT) {
          accumulator = new HorizontalCompositionTop(accumulator, this.blocks[x]);
        } else if (this.align == VAlignment.CENTER) {
          accumulator = new HorizontalCompositionCenter(accumulator, this.blocks[x]);
        } else if (this.align == VAlignment.RIGHT) {
          accumulator = new HorizontalCompositionBottom(accumulator, this.blocks[x]);
        } else {
          throw new IllegalArgumentException("Invalid alignment");
        }
      }

      return accumulator;
    }

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
    return "";  // STUB
  } // row(int)

  /**
   * Determine how many rows are in the block.
   *
   * @return the number of rows
   */
  public int height() {
    return 0;   // STUB
  } // height()

  /**
   * Determine how many columns are in the block.
   *
   * @return the number of columns
   */
  public int width() {
    return 0;   // STUB
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
    return false;       // STUB
  } // eqv(AsciiBlock)
} // class VComp
