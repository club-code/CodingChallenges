use anyhow::Result;
use day5::parse_passes;

/// Solves part 1 simply by using the parsing function and selecting
/// the desired result by maximum boarding pass ID.
fn main() -> Result<()> {
    println!(
        "{}",
        parse_passes()?
            .into_iter()
            .map(|pass| pass.id())
            .max()
            .unwrap()
    );
    Ok(())
}
