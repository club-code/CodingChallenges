use anyhow::Result;
use day3::parse_grid;

fn main() -> Result<()> {
    let grid = parse_grid()?;
    let width = grid[0].len();

    println!(
        "{}",
        (0..grid.len()).filter(|&i| grid[i][3 * i % width]).count()
    );

    Ok(())
}
