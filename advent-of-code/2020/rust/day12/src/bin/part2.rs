use anyhow::{anyhow, Result};
use day12::*;

/// Solves part two by storing the waypoint offsets and rotating them when needed.
fn main() -> Result<()> {
    let mut si = 0;
    let mut sj = 0;
    let mut wi = -1;
    let mut wj = 10;

    // There is obviously repetition between left and right rotations, but I
    // was lazy to do otherwise, for example with a recursive function...
    while let Some(action) = parse_action()? {
        match action {
            Action::North(value) => wi -= value,
            Action::South(value) => wi += value,
            Action::East(value) => wj += value,
            Action::West(value) => wj -= value,
            Action::Left(value) => match value {
                90 => {
                    let tmp = wi;
                    wi = -wj;
                    wj = tmp;
                }
                180 => {
                    wi *= -1;
                    wj *= -1;
                }
                270 => {
                    let tmp = wi;
                    wi = wj;
                    wj = -tmp;
                }
                dir => return Err(anyhow!("Unsupported direction: {}", dir)),
            }
            Action::Right(value) => match value {
                90 => {
                    let tmp = wi;
                    wi = wj;
                    wj = -tmp;
                }
                180 => {
                    wi *= -1;
                    wj *= -1;
                }
                270 => {
                    let tmp = wi;
                    wi = -wj;
                    wj = tmp;
                }
                dir => return Err(anyhow!("Unsupported direction: {}", dir)),
            }
            Action::Forward(value) => {
                si += wi * value;
                sj += wj * value;
            }
        }
    }

    println!("{}", si.abs() + sj.abs());
    Ok(())
}
