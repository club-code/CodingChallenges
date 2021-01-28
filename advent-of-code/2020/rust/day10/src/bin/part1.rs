use anyhow::Result;
use day10::parse_ratings;

/// Solves part 1 by sorting, counting the 1 and 3 differences and multiplying them.
pub fn main() -> Result<()> {
    let mut ratings = parse_ratings()?;
    ratings.sort_unstable();

    let (ones, threes) =
        (0..ratings.len() - 1).fold((0, 0), |(o, t), i| match ratings[i + 1] - ratings[i] {
            1 => (o + 1, t),
            3 => (o, t + 1),
            _ => (o, t),
        });

    // The input sequence does not include the starting 0 and ending maximum,
    // so we have to add them to the counts before multiplying.
    println!("{}", (ones + 1) * (threes + 1));
    Ok(())
}
