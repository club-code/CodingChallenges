use std::collections::HashMap;
use std::io;

use anyhow::Result;

pub fn parse_passport() -> Result<HashMap<String, String>> {
    let stdin = io::stdin();
    let mut line = String::new();
    let mut set = HashMap::new();

    while stdin.read_line(&mut line)? != 0 && !line.trim_end().is_empty() {
        set.extend(line.split_whitespace().map(|couple| {
            let mut parts = couple.split(':');
            (
                parts.next().unwrap().to_owned(),
                parts.next().unwrap().to_owned(),
            )
        }));
        line.clear();
    }

    Ok(set)
}

pub fn count_valid_passports(validator: fn(&HashMap<String, String>) -> bool) -> Result<u16> {
    let mut valid = 0;

    loop {
        let pass = parse_passport()?;

        if pass.is_empty() {
            break;
        } else {
            valid += validator(&pass) as u16;
        }
    }

    Ok(valid)
}

pub fn validate_passport1(pass: &HashMap<String, String>) -> bool {
    pass.len() == 8 || pass.len() == 7 && !pass.contains_key("cid")
}

pub fn validate_passport2(pass: &HashMap<String, String>) -> bool {
    validate_passport1(pass)
        && [
            validate_byr,
            validate_iyr,
            validate_eyr,
            validate_hgt,
            validate_hcl,
            validate_ecl,
            validate_pid,
        ]
        .iter()
        .all(|fct| fct(pass))
}

fn validate_number(repr: &str, min: u16, max: u16) -> bool {
    repr.parse::<u16>()
        .map_or(false, |num| min <= num && num <= max)
}

fn validate_num_field(pass: &HashMap<String, String>, field: &str, min: u16, max: u16) -> bool {
    pass.get(field)
        .map_or(false, |val| validate_number(val, min, max))
}

fn validate_byr(pass: &HashMap<String, String>) -> bool {
    validate_num_field(pass, "byr", 1920, 2002)
}

fn validate_iyr(pass: &HashMap<String, String>) -> bool {
    validate_num_field(pass, "iyr", 2010, 2020)
}

fn validate_eyr(pass: &HashMap<String, String>) -> bool {
    validate_num_field(pass, "eyr", 2020, 2030)
}

fn validate_hgt(pass: &HashMap<String, String>) -> bool {
    pass.get("hgt").map_or(false, |val| {
        if let Some(height) = val.strip_suffix("cm") {
            validate_number(height, 150, 193)
        } else if let Some(height) = val.strip_suffix("in") {
            validate_number(height, 59, 76)
        } else {
            false
        }
    })
}

fn validate_hcl(pass: &HashMap<String, String>) -> bool {
    pass.get("hcl").map_or(false, |val| {
        val.strip_prefix('#')
            .map_or(false, |hex| hex.chars().all(|chr| chr.is_ascii_hexdigit()))
    })
}

fn validate_ecl(pass: &HashMap<String, String>) -> bool {
    pass.get("ecl").map_or(false, |val| {
        ["amb", "blu", "brn", "gry", "grn", "hzl", "oth"].contains(&val.as_str())
    })
}

fn validate_pid(pass: &HashMap<String, String>) -> bool {
    pass.get("pid").map_or(false, |val| {
        val.len() == 9 && val.chars().all(|chr| chr.is_ascii_digit())
    })
}
