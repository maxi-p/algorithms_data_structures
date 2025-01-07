class Solution:
	def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
		hash = {}
		res = []
		for str in strs:
			sortedStr = ''.join(sorted(str))
			if sortedStr in hash:
				hash[sortedStr].append(str)
			else:
				newList = [str]
				hash[sortedStr] = newList
		for key, value in hash.items():
			res.append(value)
		
		return res
