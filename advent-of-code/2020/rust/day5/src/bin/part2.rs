use anyhow::Result;
use day5::{parse_passes, ROWS};

fn main() -> Result<()> {
    let passes = parse_passes()?;

    for pass in passes.iter() {
        if ![0, ROWS].contains(&pass.row) {
            if passes.contains(&pass.next(2)) && !passes.contains(&pass.next(1)) {
                println!("{}", pass.next(1).id());
                break;
            } else if passes.contains(&pass.prev(2)) && !passes.contains(&pass.prev(1)) {
                println!("{}", pass.prev(1).id());
                break;
            }
        }
    }

    Ok(())
}
