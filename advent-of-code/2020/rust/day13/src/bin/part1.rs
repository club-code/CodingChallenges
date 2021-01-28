use anyhow::Result;
use day13::*;

/// Solves part 1 by finding the bus with the minimum timestamp difference and
/// computing its product with its id.
fn main() -> Result<()> {
    let notes = parse_notes()?;
    let (min_id, min_ts) = notes
        .buses
        .iter()
        .map(|&(_, id)| {
            let rest = notes.timestamp % id;
            (id, notes.timestamp + if rest != 0 { id - rest } else { 0 })
        })
        .min_by_key(|&(_, ts)| ts)
        .unwrap();

    println!("{}", (min_ts - notes.timestamp) * min_id);
    Ok(())
}
