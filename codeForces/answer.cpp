#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>
#include <map>

using namespace std;

typedef long long int LL;

LL n,m,k;

bool ck(LL x)
{
    LL nt=0;
    for(LL i=1;i<=n;i++)
    {
        nt+=min(m,x/i);
    }
    if(nt>=k) return true;
    return false;
}

int main()
{
    scanf("%I64d%I64d%I64d",&n,&m,&k);

    LL low=1,high=n*m,ans=-1,mid;
    while(low<=high)
    {
        mid=(low+high)/2;
        if(ck(mid))
        {
            ans=mid; high=mid-1;
        }
        else low=mid+1;
    }
    printf("%I64d\n",ans);

    return 0;
}
