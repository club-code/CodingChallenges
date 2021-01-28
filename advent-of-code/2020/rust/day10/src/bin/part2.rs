use anyhow::Result;
use day10::parse_ratings;

/// Solves part 2 by sorting and counting arrangements using consecutive packs.
pub fn main() -> Result<()> {
    let mut ratings = parse_ratings()?;
    ratings.sort_unstable();
    ratings.insert(0, 0);

    println!("{}", arrangements(&ratings));
    Ok(())
}

/// Computes and returns the number of possible plugging arrangements.
fn arrangements(ratings: &[u8]) -> u64 {
    let mut prev = 0;
    let mut pack_start = 0;

    ratings
        .iter()
        .copied()
        .enumerate()
        // Group into consecutive packs and yield their lengths.
        .fold(Vec::new(), |mut acc, (i, rat)| {
            if i != 0 && rat != prev + 1 {
                if i - pack_start > 1 {
                    acc.push(i - pack_start);
                }

                pack_start = i;
            }

            if i == ratings.len() - 1 && i - pack_start > 1 {
                acc.push(i - pack_start + 1);
            }

            prev = rat;
            acc
        })
        .into_iter()
        // Map pack lengths to inherent number of arrangements,
        .map(|len| tri_fib(len as u64 - 2))
        // and multiply these to obtain the result.
        .product()
}

/// Computes and returns the `n`-th term of the third-order fibonacci series.
fn tri_fib(n: u64) -> u64 {
    /// Recursive implementation based on triples.
    fn rec(n: u64) -> (u64, u64, u64) {
        match n {
            0 => (1, 0, 0),
            1 => (2, 1, 0),
            2 => (4, 2, 1),
            _ => {
                let (fst, snd, thd) = rec(n - 1);
                (fst + snd + thd, fst, snd)
            }
        }
    }

    rec(n).0
}
