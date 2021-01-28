use anyhow::Result;
use std::io::{self, BufRead};

/// Solves the second part by... parsing and counting!
fn main() -> Result<()> {
    let mut count = 0;

    for line in io::stdin().lock().lines() {
        let line = line?;
        let parts = line.split_whitespace().collect::<Vec<_>>();

        let letter = parts[1].as_bytes()[0];
        let pswd = parts[2].as_bytes();

        // This time, the iterator can be used directly.
        count += (parts[0]
            .splitn(2, '-')
            .map(|s| s.parse::<usize>().unwrap())
            .filter(|&n| pswd[n - 1] == letter)
            .count()
            == 1) as u16;
    }

    println!("{}", count);
    Ok(())
}
