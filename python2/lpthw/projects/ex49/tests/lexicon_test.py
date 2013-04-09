from nose.tools import *
from ex49 import lexicon


def test_peek():
    assert_equal(lexicon.peek([('direction', 'north')]), 'direction')
    result = lexicon.peek([('direction', 'north'),
                          ('direction', 'south'),
                          ('direction', 'east')])
    assert_equal(result, 'direction')
    assert_equal(lexicon.peek([('direction', 'bear')]), 'direction')

def test_match():
    assert_equal(lexicon.match([('verb', 'go')], 'verb'), ('verb','go'))
    result = lexicon.match([('verb', 'go'),
                          ('verb', 'kill'),
                          ('verb', 'eat')], 'verb')
    assert_equal(result, ('verb','go'))
    assert_equal(lexicon.match([('verb', 'go')], 'noun'), None)
    assert_equal(lexicon.match([('verb', 'north')], 'verb'), ('verb', 'north'))

def test_skip():
    assert_equal(lexicon.skip([('stop', 'the')], 'stop'), None)
    result = lexicon.skip([('stop', 'the'),
                          ('stop', 'in'),
                          ('stop', 'of')], 'stop')
    assert_equal(result, None)
    assert_equal(lexicon.skip(('stop', 'the'), 'verb'), None)


def test_parse_verb():
    assert_equal(lexicon.parse_verb([('verb', 'kill')]), ('verb', 'kill'))
    result = lexicon.parse_verb([('verb', 'go'),
                                 ('verb', 'kill'),
                                 ('verb', 'eat')])
    assert_equal(result, ('verb', 'go'))

def test_parse_object():
    
    result = lexicon.parse_object([('direction', 'north'),
                                   ('direction', 'south'),
                                   ('direction', 'east')])
    assert_equal(result, ('direction', 'north'))
    assert_equal(lexicon.parse_object([('noun', 'bear')]), ('noun', 'bear'))
    assert_equal(lexicon.parse_object([('direction', 'south')]), ('direction', 'south'))


def test_parse_subject():
    result = lexicon.parse_subject([('verb', 'kill'),
                                    ('noun', 'princess')], ('noun', 'bear'))                                  
    assert_equal(result.subject, 'bear')
    assert_equal(result.verb, 'kill')
    assert_equal(result.object_, 'princess')   

def test_parse_sentence():
    result = lexicon.parse_sentence([('verb', 'kill'),
                                    ('noun', 'princess')])                                  
    assert_equal(result.subject,'player')
    assert_equal(result.verb,'kill')
    assert_equal(result.object_,'princess')


assert_raises_regexp(lexicon.ParserError, 'Expected a verb next.', lexicon.parse_verb, [('noun', 'bear')]) 
assert_raises_regexp(lexicon.ParserError, 'Expected a verb next.', lexicon.parse_verb, [('stop', 'of')]) 
assert_raises_regexp(lexicon.ParserError, 'Expected a verb next.', lexicon.parse_verb, [('noun', 'bear'),
                        ('noun', 'princess'),
                        ('verb', 'kill')]) 
assert_raises_regexp(lexicon.ParserError, 'Expected a verb next.', lexicon.parse_subject,[('error', 'ASDFADFASDF')], 'bear') 
assert_raises_regexp(lexicon.ParserError, 'Expected a verb next.', lexicon.parse_sentence,[('noun', 'bear')]) 

   
assert_raises_regexp(lexicon.ParserError, "Expected a noun or direction next.", lexicon.parse_object,[('number', 1234)]) 
assert_raises_regexp(lexicon.ParserError, "Expected a noun or direction next.", lexicon.parse_object,[('number', 3),
                        ('number', 91234)]) 
assert_raises_regexp(lexicon.ParserError, "Expected a noun or direction next.", lexicon.parse_subject,[('verb', 'kill'),
                        ('stop', 'the')], 'bear') 
assert_raises_regexp(lexicon.ParserError, "Expected a noun or direction next.", lexicon.parse_sentence,[('noun', 'bear'),
                        ('verb', 'kill'),
                        ('stop', 'the')]) 


assert_raises_regexp(lexicon.ParserError, "Must start with subject, object, or verb not: error", 
lexicon.parse_sentence,[('error', 'ASDFADFASDF')])

