use anyhow::Result;
use day5::parse_passes;

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
