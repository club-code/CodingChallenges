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
