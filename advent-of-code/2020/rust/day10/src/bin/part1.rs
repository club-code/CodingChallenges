use anyhow::Result;
use day10::parse_ratings;

pub fn main() -> Result<()> {
    let mut ratings = parse_ratings()?;
    ratings.sort_unstable();

    let (ones, threes) =
        (0..ratings.len() - 1).fold((0, 0), |(o, t), i| match ratings[i + 1] - ratings[i] {
            1 => (o + 1, t),
            3 => (o, t + 1),
            _ => (o, t),
        });
    println!("{}", (ones + 1) * (threes + 1));

    Ok(())
}
