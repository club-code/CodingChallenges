use anyhow::Result;
use std::io;

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

pub fn count_trees(grid: &Vec<Vec<bool>>, (down, right): (usize, usize)) -> usize {
    let width = grid[0].len();
    (0..grid.len())
        .step_by(down)
        .filter(|&i| grid[i][i / down * right % width])
        .count()
}

pub fn mult_counts(grid: &Vec<Vec<bool>>, slopes: &[(usize, usize)]) -> usize {
    slopes
        .iter()
        .map(|&slope| count_trees(grid, slope))
        .product()
}
