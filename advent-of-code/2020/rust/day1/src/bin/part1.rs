use anyhow::Result;
use day1::parse_numbers;

fn dicho_search(num: u32, arr: &[u32]) -> bool {
    let mut start = 0;
    let mut end = arr.len();

    while start + 1 != end {
        let middle = (start + end) / 2;

        if num == arr[middle] {
            return true;
        } else if num < arr[middle] {
            end = middle;
        } else {
            start = middle;
        }
    }

    false
}

fn main() -> Result<()> {
    let mut numbers = parse_numbers()?;
    numbers.sort();

    if let Some(num) = numbers
        .iter()
        .find(|&&num| dicho_search(2020 - num, &numbers))
    {
        println!("{}", num * (2020 - num));
    }

    Ok(())
}
