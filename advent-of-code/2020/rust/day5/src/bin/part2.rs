use anyhow::Result;
use day5::{parse_passes, ROWS};

/// Solves part 2 by traversing the parsed boarding passes and trying to find
/// a gap between the current one and two seats further left or right.
fn main() -> Result<()> {
    let passes = parse_passes()?;

    for pass in passes.iter() {
        // Exclude the first and last rows.
        if ![0, ROWS].contains(&pass.row) {
            // Two seats right taken and seat right free.
            if passes.contains(&pass.next(2)) && !passes.contains(&pass.next(1)) {
                // Don't care about small recomputation: occurs only once.
                println!("{}", pass.next(1).id());
                break;
            // Two seats left taken and seat left free.
            } else if passes.contains(&pass.prev(2)) && !passes.contains(&pass.prev(1)) {
                println!("{}", pass.prev(1).id());
                break;
            }
        }
    }

    Ok(())
}
