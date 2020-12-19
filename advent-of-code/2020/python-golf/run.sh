if [[ "$#" != "1" ]]; then
  echo "Usage: $0 <day number>"
  exit 1
fi

day="day$1"
infile="../resources/$day/input.in"
echo "Step 1:"
(wc -l < $infile; cat $infile) | python "$day/step1.py" 2>/dev/null # On cache la sortie d'erreur
echo; echo
echo "Step 2:"
(wc -l < $infile; cat $infile) | python "$day/step2.py" 2>/dev/null
echo