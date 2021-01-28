use anyhow::Result;
use std::io::{self, BufRead};

/// Solves the first part by parsing and counting.
fn main() -> Result<()> {
    let mut count = 0;

    // Read lines one by one.
    for line in io::stdin().lock().lines() {
        let line = line?;
        let parts = line.split_whitespace().collect::<Vec<_>>();
        let mut min_max = parts[0].splitn(2, '-').map(|s| s.parse());

        // Split them into the range numbers, letter and password.
        let min = min_max.next().unwrap()?;
        let max = min_max.next().unwrap()?;
        let letter = parts[1].as_bytes()[0] as char;
        let pswd = parts[2];

        // Update the count of valid password.
        let num = pswd.chars().filter(|&chr| chr == letter).count();
        count += (min <= num && num <= max) as usize;
    }

    // Return the result.
    println!("{}", count);
    Ok(())
}
