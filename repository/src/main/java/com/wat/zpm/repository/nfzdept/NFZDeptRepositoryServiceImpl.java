package com.wat.zpm.repository.nfzdept;

import com.wat.model.NFZDept;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
class NFZDeptRepositoryServiceImpl implements NFZDeptRepositoryService {

    private final NFZDeptEntityMapper nfzDeptEntityMapper;
    private final NFZDeptRepository nfzDeptRepository;

    public NFZDeptRepositoryServiceImpl(NFZDeptEntityMapper nfzDeptEntityMapper, NFZDeptRepository nfzDeptRepository) {
        this.nfzDeptEntityMapper = nfzDeptEntityMapper;
        this.nfzDeptRepository = nfzDeptRepository;
    }

    @Override
    public Set<NFZDept> list() {
        return nfzDeptRepository.findAll()
                .stream()
                .map(nfzDeptEntityMapper::nfzDeptEntityToNFZDept)
                .collect(Collectors.toSet());
    }

    @Override
    public NFZDept findById(int id) {
        return nfzDeptEntityMapper.nfzDeptEntityToNFZDept(nfzDeptRepository.getOne(id));
    }

    @Override
    public Set<NFZDept> findByIds(Set<Integer> ids) {
        return nfzDeptRepository.findAllByIdIn(ids)
                .stream()
                .map(nfzDeptEntityMapper::nfzDeptEntityToNFZDept)
                .collect(Collectors.toSet());
    }

    @Override
    public NFZDept update(NFZDept nfzDept) {
        return null;
    }

    @Override
    public NFZDept save(NFZDept nfzDept) {
        return nfzDeptEntityMapper.nfzDeptEntityToNFZDept(
                nfzDeptRepository.save(
                        nfzDeptEntityMapper.nfzDeptToNFZDeptEntity(nfzDept)
                )
        );
    }
}
