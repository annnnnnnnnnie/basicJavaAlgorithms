-- http://wp.doc.ic.ac.uk/ajf/binomial-heaps/
type BinHeap a = [BinTree a] -- the BinTrees in a BinHeap satisfy (rank i) < (rank j) <=> i < j

data BinTree a = Node a Int (BinHeap a) -- the BinTrees in this BinHeap satisfy (rank i) > (rank j) <=> i < j
  deriving (Eq, Ord, Show)

--------------------------------------------------------------
-- PART I

key :: BinTree a -> a
key (Node k _ _) = k

rank :: BinTree a -> Int
rank (Node _ r _) = r

children :: BinTree a -> [BinTree a]
children (Node _ _ ts) = ts

combineTrees :: Ord a => BinTree a -> BinTree a -> BinTree a
combineTrees t1 t2
  | key t1 >= key t2 = Node (key t2) r (t1 : children t2)
  | otherwise = Node (key t1) r (t2 : children t1)
  where
    r
      | rank t1 /= rank t2 = error "Cannot combine trees of different ranks"
      | otherwise = rank t1 + 1

--------------------------------------------------------------
-- PART II

extractMin :: Ord a => BinHeap a -> a
extractMin = minimum . map key

mergeHeaps :: Ord a => BinHeap a -> BinHeap a -> BinHeap a
mergeHeaps [] bh = bh
mergeHeaps bh [] = bh
mergeHeaps bh@(t : ts) bh'@(t' : ts')
  | rt < rt' = t : mergeHeaps ts bh'
  | rt > rt' = t' : mergeHeaps bh ts'
  | otherwise = mergeHeaps [tt'] (mergeHeaps ts ts')
  where
    rt = rank t
    rt' = rank t'
    tt' = combineTrees t t'

insert :: Ord a => a -> BinHeap a -> BinHeap a
insert = mergeHeaps . single

single :: Ord a => a -> BinHeap a
single x = [Node x 0 []]

deleteMin :: Ord a => BinHeap a -> BinHeap a
deleteMin bh = bh'
  where
    (_, bh') = removeMin bh

remove :: Ord a => a -> BinHeap a -> BinHeap a
remove x bh = mergeHeaps bhFrombt $ mergeHeaps left right
  where
    (left, bt : right) = break ((== x) . key) bh
    bhFrombt = reverse $ children bt

removeMin :: Ord a => BinHeap a -> (BinTree a, BinHeap a)
removeMin bh = ((head . single) minValue, remove minValue bh)
  where
    minValue = extractMin bh

binSort :: Ord a => [a] -> [a]
binSort =
  undefined

--------------------------------------------------------------
-- PART III

toBinary :: BinHeap a -> [Int]
toBinary =
  undefined

binarySum :: [Int] -> [Int] -> [Int]
binarySum =
  undefined

------------------------------------------------------
-- Some tests
check :: IO ()
check = do
  print (key t4 == 2)
  print (rank t7 == 3)
  print (children t2 == [Node 5 0 []])
  print (combineTrees t5 t6 == t7)
  print (extractMin h3 == 1)
  print (mergeHeaps h4 h5 == h6)
  print (deleteMin h6 == h7)

------------------------------------------------------
-- Some sample trees...

t1, t2, t3, t4, t5, t6, t7, t8 :: BinTree Int
-- Note: t7 is the result of merging t5 and t6

-- t1 to t4 appear in Figure 1...
t1 = Node 4 0 []
t2 = Node 1 1 [Node 5 0 []]
t3 =
  Node
    2
    2
    [ Node 8 1 [Node 9 0 []],
      Node 7 0 []
    ]
t4 =
  Node
    2
    3
    [ Node
        3
        2
        [ Node 6 1 [Node 8 0 []],
          Node 10 0 []
        ],
      Node 8 1 [Node 9 0 []],
      Node 7 0 []
    ]
-- t5 and t6 are on the left of Figure 2; t7 is on the
-- right
t5 =
  Node
    4
    2
    [ Node 6 1 [Node 8 0 []],
      Node 10 0 []
    ]
t6 = Node 2 2 [Node 8 1 [Node 9 0 []], Node 7 0 []]
t7 =
  Node
    2
    3
    [ Node 4 2 [Node 6 1 [Node 8 0 []], Node 10 0 []],
      Node 8 1 [Node 9 0 []],
      Node 7 0 []
    ]
-- An additional tree...
t8 = Node 12 1 [Node 16 0 []]

------------------------------------------------------
-- Some sample heaps...

h1, h2, h3, h4, h5, h6, h7 :: BinHeap Int
-- Two arbitrary heaps for testing...
h1 = [t2, t7]
h2 =
  [ Node
      1
      2
      [ Node 12 1 [Node 16 0 []],
        Node 5 0 []
      ],
    Node
      2
      3
      [ Node
          4
          2
          [ Node 6 1 [Node 8 0 []],
            Node 10 0 []
          ],
        Node 8 1 [Node 9 0 []],
        Node 7 0 []
      ]
  ]
-- h3 is shown in Figure 3...
h3 = [t1, t2, t4]
-- Two additional heaps, used below. They are shown
-- in Figure 4(a)...

h4 = [t2, t5]
h5 = [t1, t8]
-- h6 is the result of merging h4 and h5, shown in Figure 4(b)...
h6 =
  [ Node 4 0 [],
    Node
      1
      3
      [ Node
          4
          2
          [ Node 6 1 [Node 8 0 []],
            Node 10 0 []
          ],
        Node 12 1 [Node 16 0 []],
        Node 5 0 []
      ]
  ]
-- h7 is shown in Figure 5...
h7 =
  [ Node
      4
      3
      [ Node
          4
          2
          [ Node 12 1 [Node 16 0 []],
            Node 5 0 []
          ],
        Node 6 1 [Node 8 0 []],
        Node 10 0 []
      ]
  ]
