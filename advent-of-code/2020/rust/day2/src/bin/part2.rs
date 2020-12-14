use anyhow::Result;
use std::io;

/// Solves the second part by... parsing and counting!
fn main() -> Result<()> {
    let stdin = io::stdin();
    let mut line = String::new();
    let mut count = 0;

    while stdin.read_line(&mut line)? != 0 {
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

        line.clear();
    }

    println!("{}", count);
    Ok(())
}
