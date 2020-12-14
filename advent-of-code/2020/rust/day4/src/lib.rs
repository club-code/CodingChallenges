use std::collections::HashMap;
use std::io;

use anyhow::Result;

/// Type alias in order to reduce repetitive boilerplate.
type Passport = HashMap<String, String>;

/// Parses the next passport available from the standard input stream as a
/// map associating passport `String` keys to values.
pub fn parse_passport() -> Result<Passport> {
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

/// Counts the valid passports from the standard input using the given `validator`
/// function pointer, i.e. `validate_passport1` or `validate_passport2`.
pub fn count_valid_passports(validator: fn(&Passport) -> bool) -> Result<u16> {
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

/// Returns `true` iff the given passport is valid as per part-1's instructions.
pub fn validate_passport1(pass: &Passport) -> bool {
    pass.len() == 8 || pass.len() == 7 && !pass.contains_key("cid")
}

/// Returns `true` iff the given passport is valid as per part-2's instructions.
/// Builds atop `validate_passport1` in order to enforce additional constraints.
pub fn validate_passport2(pass: &Passport) -> bool {
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

/// Returns `true` iff `repr` represents an unsigned short integer contained
/// in the `[min, max]` discrete range.
fn validate_number(repr: &str, min: u16, max: u16) -> bool {
    repr.parse::<u16>()
        .map_or(false, |num| min <= num && num <= max)
}

/// Returns `true` iff the given passport has a `field` key which value
/// represents an unsigned short integer contained in the `[min, max]` range.
fn validate_num_field(pass: &Passport, field: &str, min: u16, max: u16) -> bool {
    pass.get(field)
        .map_or(false, |val| validate_number(val, min, max))
}

/// Validates the "Birth Year" passport numeric field.
fn validate_byr(pass: &Passport) -> bool {
    validate_num_field(pass, "byr", 1920, 2002)
}

/// Validates the "Issue Year" passport numeric field.
fn validate_iyr(pass: &Passport) -> bool {
    validate_num_field(pass, "iyr", 2010, 2020)
}

/// Validates the "Expiration Year" passport numeric field.
fn validate_eyr(pass: &Passport) -> bool {
    validate_num_field(pass, "eyr", 2020, 2030)
}

/// Validates the "Height" passport graduated field.
fn validate_hgt(pass: &Passport) -> bool {
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

/// Validates the "Hair Color" passport hexadecimal color field.
fn validate_hcl(pass: &Passport) -> bool {
    pass.get("hcl").map_or(false, |val| {
        val.strip_prefix('#')
            .map_or(false, |hex| hex.chars().all(|chr| chr.is_ascii_hexdigit()))
    })
}

/// Validates the "Eye Color" passport enumeration field.
fn validate_ecl(pass: &Passport) -> bool {
    pass.get("ecl").map_or(false, |val| {
        ["amb", "blu", "brn", "gry", "grn", "hzl", "oth"].contains(&val.as_str())
    })
}

/// Validates the "Passport ID" field.
fn validate_pid(pass: &Passport) -> bool {
    pass.get("pid").map_or(false, |val| {
        val.len() == 9 && val.chars().all(|chr| chr.is_ascii_digit())
    })
}
