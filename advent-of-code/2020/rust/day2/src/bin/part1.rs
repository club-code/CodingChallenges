use anyhow::Result;
use std::io;

fn main() -> Result<()> {
    let stdin = io::stdin();
    let mut line = String::new();
    let mut count = 0;

    while stdin.read_line(&mut line)? != 0 {
        let parts = line.split_whitespace().collect::<Vec<_>>();
        let mut min_max = parts[0].splitn(2, '-').map(|s| s.parse());

        let min = min_max.next().unwrap()?;
        let max = min_max.next().unwrap()?;
        let letter = parts[1].as_bytes()[0] as char;
        let pswd = parts[2];

        let num = pswd.chars().filter(|&chr| chr == letter).count();
        count += (min <= num && num <= max) as usize;

        line.clear();
    }

    println!("{}", count);
    Ok(())
}
