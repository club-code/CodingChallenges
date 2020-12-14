use anyhow::Result;
use std::io;

/// Parses the standard input in a grid of booleans: `true` iff a tree.
/// Note that the use of `Vec<Vec<bool>>` is not the most efficient, it
/// is just the easiest here.
pub fn parse_grid() -> Result<Vec<Vec<bool>>> {
    let stdin = io::stdin();
    let mut line = String::new();
    let mut grid = Vec::new();

    while stdin.read_line(&mut line)? != 0 {
        grid.push(line.trim_end().chars().map(|chr| chr == '#').collect());
        line.clear();
    }

    Ok(grid)
}

/// Counts the trees in the `grid` following the given `(down, right)` slope.
pub fn count_trees(grid: &Vec<Vec<bool>>, (down, right): (usize, usize)) -> usize {
    let width = grid[0].len();
    (0..grid.len())
        .step_by(down)
        .filter(|&i| grid[i][i / down * right % width])
        .count()
}

/// Computes the product of all the tree counts for the given `slopes`.
pub fn mult_counts(grid: &Vec<Vec<bool>>, slopes: &[(usize, usize)]) -> usize {
    slopes
        .iter()
        .map(|&slope| count_trees(grid, slope))
        .product()
}
