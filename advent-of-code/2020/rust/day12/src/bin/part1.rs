use anyhow::{anyhow, Result};
use day12::*;

/// Solves part 1 by following the actions using a stored direction angle.
fn main() -> Result<()> {
    let mut dir = 0;
    let mut i = 0;
    let mut j = 0;

    while let Some(action) = parse_action()? {
        match action {
            Action::North(value) => i -= value,
            Action::South(value) => i += value,
            Action::East(value) => j += value,
            Action::West(value) => j -= value,
            Action::Left(value) => dir = (dir + value).rem_euclid(360),
            Action::Right(value) => dir = (dir - value).rem_euclid(360),
            Action::Forward(value) => match dir {
                0 => j += value,   // East.
                90 => i -= value,  // North.
                180 => j -= value, // West.
                270 => i += value, // South.
                _ => return Err(anyhow!("Unsupported direction: {}", dir)),
            },
        }
    }

    println!("{}", i.abs() + j.abs());
    Ok(())
}
